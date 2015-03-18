package br.com.ifrn.workbook.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ifrn.workbook.model.PasswordResetToken;
import br.com.ifrn.workbook.model.servico.PasswordResetTokenService;
import br.com.ifrn.workbook.model.user.Role;
import br.com.ifrn.workbook.model.user.UserAccount;
import br.com.ifrn.workbook.service.UserService;

@RestController
@RequestMapping(value = "usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Inject private UserService userService;
	@Inject private JavaMailSender javaMail;
	@Inject private PasswordResetTokenService passwordResetTokenService;
		
	@RequestMapping(value="criar", method=RequestMethod.GET)
	public ModelAndView form() {
		return new ModelAndView("usuario/criar", "usuario", new UserAccount());
	}
	
	@RequestMapping(value = "criar", method= RequestMethod.POST)
	public ModelAndView criar(@ModelAttribute UserAccount usuario) {
		usuario.setRole(Role.ROLE_USER);
		userService.registerNewUserAccount(usuario);
		return new ModelAndView("redirect:/");
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "editar/{id}", method = RequestMethod.GET )
	public ModelAndView editar(@PathVariable Long id) {
		return new ModelAndView("usuario/editar", "usuario", userService.getById(id));
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "editar/{id}", method = RequestMethod.POST)
	public ModelAndView editar(@ModelAttribute UserAccount usuario, @PathVariable Long id) {
		usuario.setId(id);
		userService.update(usuario);
		return new ModelAndView("redirect:/");
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "deletar/{id}")
	public ModelAndView deletar(@PathVariable Long id) {
		userService.delete(id);
		return new ModelAndView("redirect:/");
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "listar", method = RequestMethod.GET) 
	public ModelAndView listar() {
		return new ModelAndView("usuario/listar", "usuarios", userService.getAll());
	}
	
	@RequestMapping(value = "reset_password", method = RequestMethod.GET)
	public ModelAndView resetPassword() {
		return new ModelAndView("usuario/reset_password");
	}	
	
	@RequestMapping(value = "reset_password", method = RequestMethod.POST)
	public ModelAndView resetPassword(@RequestParam("email") String email, HttpServletRequest request, RedirectAttributes redirect) {
		UserAccount user = userService.getByEmail(email);
		if (user != null) {
			redirect.addFlashAttribute("globalMessage", "email enviado!");
			sendEmail(getUrlServer(request), passwordResetTokenService.createPasswordReset(user));
		} else {			
			redirect.addFlashAttribute("globalMessage", "email inválido!");
		}		
		return new ModelAndView("redirect:/usuario/reset_password");
	}

	@RequestMapping(value = "change_password", method = RequestMethod.GET)
	public ModelAndView changePassword() {
		return new ModelAndView("usuario/change_password");
	}

	public ModelAndView changePassword(@RequestParam("user") Long user, @RequestParam("password") String password, @RequestParam("token") String token) {
		return null;
	}
	
	private void sendEmail(String url, PasswordResetToken reset) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo("evangilo@localhost");
		mailMessage.setReplyTo("workbook@localhost");
		mailMessage.setFrom("evangilo@localhost");
		mailMessage.setSubject("Resetar senha workbook");
		mailMessage.setText(getUrlPasswordReset(url, reset));
		javaMail.send(mailMessage);
	}
	
	private String getUrlServer(HttpServletRequest request) {		
		return String.format("%s:%s", request.getServerName(), request.getServerPort());
	}
	
	private String getUrlPasswordReset(String url, PasswordResetToken reset) {
		return String.format("%s/usuario/change_password?user=%s&token=&%s", url, reset.getUser().getId(), reset.getToken());
	}
	
}
