package br.com.ifrn.workbook.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.ifrn.workbook.model.servico.Avaliacao;
import br.com.ifrn.workbook.model.servico.Servico;
import br.com.ifrn.workbook.model.user.UserAccount;
import br.com.ifrn.workbook.repository.AvaliacaoRepository;
import br.com.ifrn.workbook.utils.SecurityContextUtils;

@Service
public class AvaliacaoService extends BaseService<Avaliacao, Long> {
	
	private final AvaliacaoRepository avaliacaoRepository;
	private final ServicoService servicoService;
	private final UserService userService;
	
	
	@Inject
	public AvaliacaoService(AvaliacaoRepository avaliacaoRepository, ServicoService servicoService, UserService userService) {
		super(avaliacaoRepository);
		this.avaliacaoRepository = avaliacaoRepository;
		this.servicoService = servicoService;
		this.userService = userService;
	}
	
	
	public Avaliacao create(Avaliacao avaliacao, Long servicoID) {
		Servico servico = servicoService.getById(servicoID);
		UserAccount user = SecurityContextUtils.getUser(userService);
		avaliacao.setUsuario(user);
		avaliacao.setServico(servico);
		return super.create(avaliacao);
	}
	
	public List<Avaliacao> getByServico(Long servicoID) {
		return avaliacaoRepository.findByServicoId(servicoID);
	}

}
