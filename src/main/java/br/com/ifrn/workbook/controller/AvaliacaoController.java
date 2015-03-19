package br.com.ifrn.workbook.controller;

import javax.inject.Inject;

import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ifrn.workbook.model.servico.Avaliacao;
import br.com.ifrn.workbook.model.servico.Servico;
import br.com.ifrn.workbook.service.AvaliacaoService;
import br.com.ifrn.workbook.service.ServicoService;

@RestController
@RequestMapping("avaliacao")
public class AvaliacaoController {

	@Inject private AvaliacaoService avaliacaoService;
	@Inject private ServicoService servicoService;
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "criar", method = RequestMethod.GET)
	public ModelAndView formCriar(@ModelAttribute Avaliacao avaliacao) {		
		return new ModelAndView("avaliacao/form");
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "editar/{id}", method = RequestMethod.GET)
	public ModelAndView formEditar(@PathVariable("id") Long id) {
		Avaliacao avaliacao = avaliacaoService.getById(id);
		return new ModelAndView("avaliacao/editar", "avaliacao", avaliacao);
	}

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public ModelAndView listar() {
		return new ModelAndView("avaliacao/listar", "avaliacoes",
				avaliacaoService.getAll());
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "criar", method = RequestMethod.POST)
	public ModelAndView criar(@ModelAttribute Avaliacao avaliacao, @RequestParam("servicoID") Long servicoID,
			BindingResult result, RedirectAttributes redirect) {
		
		avaliacaoService.create(avaliacao, servicoID);
		Servico servico = servicoService.getServicoPorID(servicoID);
		servico.setMedia(servicoService.getMediaAvaliacoes(servicoID));
		servico.setTotal(servicoService.getTotalAvaliacoes(servicoID));
		servicoService.update(servico);
		redirect.addFlashAttribute("globalMessage", "Avaliação criada!");
		return new ModelAndView("redirect:/servico/detalhar/"+servicoID);
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "editar", method = RequestMethod.POST)
	public ModelAndView editar(@ModelAttribute Avaliacao avaliacao,
			RedirectAttributes redirect) {
		avaliacaoService.update(avaliacao);
		redirect.addFlashAttribute("globalMessage", "Avaliação atualizada!");
		return new ModelAndView("redirect:listar");
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "deletar/{id}")
	public ModelAndView deletar(@PathVariable("id") Long id,
			RedirectAttributes redirect) {
		avaliacaoService.delete(id);
		redirect.addFlashAttribute("globalMessage", "Avaliação removida!");
		return new ModelAndView("redirect:/avaliacao/listar");
	}

}
