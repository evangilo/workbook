package br.com.ifrn.workbook.controller;

import javax.inject.Inject;

import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ifrn.workbook.model.servico.Categoria;
import br.com.ifrn.workbook.service.CategoriaService;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

	@Inject private CategoriaService categoriaService;
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "criar", method=RequestMethod.GET)
	public ModelAndView formCriar(@ModelAttribute Categoria categoria) {
		return new ModelAndView("categoria/criar");
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "editar/{id}", method=RequestMethod.GET)
	public ModelAndView formEditar(@PathVariable("id") Long id) {
		Categoria categoria = categoriaService.getById(id);
		return new ModelAndView("categoria/editar", "categoria", categoria);
	}
		
	@RequestMapping(value = "listar", method=RequestMethod.GET)
	public ModelAndView listar() {				
		return new ModelAndView("categoria/listar", "categorias", categoriaService.getAll());
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "criar", method=RequestMethod.POST)
	public ModelAndView criar(@ModelAttribute Categoria categoria, BindingResult result, RedirectAttributes redirect) {
		categoriaService.create(categoria);
		redirect.addFlashAttribute("globalMessage", "Categoria criada!");
		return new ModelAndView("redirect:listar");
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "editar", method=RequestMethod.POST)
	public ModelAndView editar(@ModelAttribute Categoria categoria, RedirectAttributes redirect) {
		categoriaService.update(categoria);
		redirect.addFlashAttribute("globalMessage", "Categoria atualizada!");
		return new ModelAndView("redirect:listar");
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "deletar/{id}")
	public ModelAndView deletar(@PathVariable("id") Long id, RedirectAttributes redirect) {
		categoriaService.delete(id);
		redirect.addFlashAttribute("globalMessage", "Categoria removida!");
		return new ModelAndView("redirect:/categoria/listar");
	}		
}
