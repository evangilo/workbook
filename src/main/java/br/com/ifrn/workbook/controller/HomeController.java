package br.com.ifrn.workbook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.ifrn.workbook.model.servico.Servico;
import br.com.ifrn.workbook.service.CategoriaService;
import br.com.ifrn.workbook.service.ServicoService;

@Controller
@RequestMapping("/")
public class HomeController {
	private final CategoriaService categoriaService;
	private final ServicoService servicoService;

	@Inject
	public HomeController(ServicoService servicoService, CategoriaService categoriaService) {
		this.servicoService = servicoService;
		this.categoriaService = categoriaService;
	}
	
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView Home(Model model) {
		List<Servico> servicos = servicoService.findServicos("");
		return new ModelAndView("servico/busca_result", getMapView(servicos));
    }

	private Map<String, Object> getMapView(List<Servico> servicos) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("servicos", servicos);
		map.put("categorias", categoriaService.getAll());
		return map;
	}

    public String helloFacebook(Model model) {
        return "home";
    }

}
