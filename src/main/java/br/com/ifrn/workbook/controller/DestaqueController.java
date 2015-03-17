package br.com.ifrn.workbook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.ifrn.workbook.model.servico.Destaque;
import br.com.ifrn.workbook.model.servico.Servico;
import br.com.ifrn.workbook.service.DestaqueService;
import br.com.ifrn.workbook.service.ServicoService;
import br.com.ifrn.workbook.service.UserService;
import br.com.ifrn.workbook.utils.SecurityContextUtils;

@RestController
@RequestMapping("destaques")
public class DestaqueController {
	
	private final DestaqueService destaqueService;
	private final ServicoService servicoService;
	private final UserService userService;
	
	@Inject
	public DestaqueController(DestaqueService destaqueService, ServicoService servicoService, UserService userService) {
		this.destaqueService = destaqueService;
		this.servicoService  = servicoService;
		this.userService     = userService;
	}
	
	@RequestMapping(value = "criar", method=RequestMethod.POST)
	public ModelAndView criar(@ModelAttribute Destaque destaque) {
		destaqueService.create(destaque);
		return new ModelAndView("redirect:/destaques/meus_destaques");
	}	

	@RequestMapping(value = "solicitar/{id}", method=RequestMethod.GET)
	public ModelAndView formCriar(@PathVariable("id") Long servicoID) {		
		return new ModelAndView("destaque/form", getMapView(new Destaque(), servicoID));
	}
	

	@RequestMapping(value = "aceitar/{id}", method=RequestMethod.GET)
	public ModelAndView aceitar(@PathVariable("id") Long destaqueID) {
		destaqueService.aprovarDestaque(destaqueID);
		return new ModelAndView("redirect:/destaques/listar");
	}
	
	
	@RequestMapping(value = "cancelar/{id}", method=RequestMethod.GET)
	public ModelAndView cancelar(@PathVariable("id") Long destaqueID) {
		destaqueService.cancelarDestaque(destaqueID);
		return new ModelAndView("redirect:/destaques/listar");
	}
	
	@RequestMapping(value = "listar", method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Destaque> destaques = destaqueService.getAll();
		return new ModelAndView("destaque/listar", "destaques", destaques);
	}	

	@RequestMapping(value = "deletar/{id}", method=RequestMethod.GET)
	public ModelAndView deletar(@PathVariable("id") Long destaqueID) {
		destaqueService.delete(destaqueID);
		return new ModelAndView("redirect:/destaques/listar");
	}
	
	@RequestMapping(value = "meus_destaques", method=RequestMethod.GET)
	public ModelAndView listarDestaquesUsuario() {		
		List<Destaque> destaques = destaqueService.getServicosEmDestaque(SecurityContextUtils.getUser(userService));
		return new ModelAndView("destaques/listar", "destaques", destaques);
	}	

	private Map<String, Object> getMapView(Destaque destaque, Long servicoID) {
		Servico servico = servicoService.getById(servicoID);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("destaque", destaque);
		map.put("servico", servico);
		map.put("meses", getMeses());
		return map;
	}

	private Map<Integer, String> getMeses() {
		Map<Integer, String> meses = new HashMap<Integer, String>();
		meses.put(1, "1 mês");
		meses.put(2, "2 meses");
		meses.put(3, "3 meses");
		meses.put(6, "6 meses");
		meses.put(12, "12 meses");
		return meses;
	}

}
