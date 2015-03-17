package br.com.ifrn.workbook.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.ifrn.workbook.model.local.Cidade;
import br.com.ifrn.workbook.repository.CidadeRepository;

@Service
public class CidadeService extends BaseService<Cidade, Long> {
	
	private final CidadeRepository cidadeRepository;

	@Inject
	public CidadeService(CidadeRepository cidadeRepository) {
		super(cidadeRepository);
		this.cidadeRepository = cidadeRepository;
	}
	
	public List<Cidade> getByEstado(String estado) {
		return cidadeRepository.findByEstado(estado);
	}
}
