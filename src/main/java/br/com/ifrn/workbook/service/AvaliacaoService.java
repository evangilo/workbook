package br.com.ifrn.workbook.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.ifrn.workbook.model.servico.Avaliacao;
import br.com.ifrn.workbook.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService extends BaseService<Avaliacao, Long> {
	
	private final AvaliacaoRepository avaliacaoRepository;
	
	@Inject
	public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
		super(avaliacaoRepository);
		this.avaliacaoRepository = avaliacaoRepository;
	}

}
