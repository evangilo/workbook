package br.com.ifrn.workbook.controller;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.ifrn.workbook.model.user.Role;
import br.com.ifrn.workbook.model.user.UserAccount;
import br.com.ifrn.workbook.service.UserService;

@RestController
@RequestMapping(value = "usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Inject private UserService userService;
		
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
	
}
