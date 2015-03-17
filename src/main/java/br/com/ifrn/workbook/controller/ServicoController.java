package br.com.ifrn.workbook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ifrn.workbook.model.servico.Servico;
import br.com.ifrn.workbook.service.AvaliacaoService;
import br.com.ifrn.workbook.service.CategoriaService;
import br.com.ifrn.workbook.service.CidadeService;
import br.com.ifrn.workbook.service.ServicoService;
import br.com.ifrn.workbook.service.UserService;
import br.com.ifrn.workbook.utils.SecurityContextUtils;

@RestController
@RequestMapping("servico")
public class ServicoController {
	
	private final ServicoService servicoService;
	private final CategoriaService categoriaService;
	private final AvaliacaoService avaliacaoService;
	private final CidadeService cidadeService;
	private final UserService userService;	

	@Inject
	public ServicoController(ServicoService servicoService, CategoriaService categoriaService, 
			AvaliacaoService avaliacaoService, CidadeService cidadeService, UserService userService) {
		this.servicoService = servicoService;
		this.categoriaService = categoriaService;
		this.avaliacaoService = avaliacaoService;
		this.cidadeService = cidadeService;
		this.userService = userService;
	}
	
	@RequestMapping(value = "criar", method=RequestMethod.GET)
	public ModelAndView formCriar(@ModelAttribute Servico servico) {
		return new ModelAndView("servico/criar", getMapView(new Servico()));
	}
	
	@RequestMapping(value = "editar/{id}", method=RequestMethod.GET)
	public ModelAndView formEditar(@PathVariable("id") Long id) {
		Servico servico = servicoService.getById(id);
		return new ModelAndView("servico/editar", getMapView(servico));
	}	
	
	@RequestMapping(value = "listar", method=RequestMethod.GET)
	public ModelAndView listar() {				
		return new ModelAndView("servico/listar", "servicos", servicoService.getAll());
	}
	
	@RequestMapping(value = "criar", method=RequestMethod.POST)
	public ModelAndView criar(@ModelAttribute Servico servico, BindingResult result, RedirectAttributes redirect) {
		servico.setUsuario(SecurityContextUtils.getUser(userService));
		servicoService.create(servico);
		redirect.addFlashAttribute("globalMessage", "Serviço criado!");
		return new ModelAndView("redirect:listar");
	}
	
	@RequestMapping(value = "editar", method=RequestMethod.POST)
	public ModelAndView editar(@ModelAttribute Servico servico, RedirectAttributes redirect) {
		servico.setUsuario(SecurityContextUtils.getUser(userService));
		servicoService.update(servico);
		redirect.addFlashAttribute("globalMessage", "Serviço atualizado!");
		return new ModelAndView("redirect:listar");
	}
	
	@RequestMapping(value = "deletar/{id}")
	public ModelAndView deletar(@PathVariable("id") Long id, RedirectAttributes redirect) {
		servicoService.delete(id);
		redirect.addFlashAttribute("globalMessage", "Serviço removido!");
		return new ModelAndView("redirect:/servico/listar");
	}
	
	/**
	 * Método para detalhar o serviço
	 * url: /servico/id
	 */
	@RequestMapping(value = "detalhar/{id}", method=RequestMethod.GET)
	public ModelAndView detalhar(@PathVariable("id") Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("avaliacoes", avaliacaoService.getByServico(id));
		map.put("servico", servicoService.getById(id));
		return new ModelAndView("servico/detalhar", map);
	}
	
	@RequestMapping(value = "buscar", method=RequestMethod.POST) 
	public ModelAndView buscar(@RequestParam String titulo, @RequestParam(required=false) String descricao) {
		if (descricao == null) descricao = "";
		List<Servico> servicos = servicoService.findServicos(titulo, descricao);		
		return new ModelAndView("servico/busca_result", getMapView(servicos));
	}
	
	private Map<String, Object> getMapView(Servico servico) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("servico", servico);
		map.put("categorias", categoriaService.getAll());
		map.put("cidades", cidadeService.getAll());
		return map;
	}
	
	private Map<String, Object> getMapView(List<Servico> servicos) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("servicos", servicos);
		map.put("categorias", categoriaService.getAll());
		return map;
	}

}
