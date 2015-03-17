package br.com.ifrn.workbook.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.ifrn.workbook.model.servico.Servico;
import br.com.ifrn.workbook.repository.ServicoRepository;

@Service
public class ServicoService extends BaseService<Servico, Long> {

	private final ServicoRepository servicoRepository;

	@Inject
	public ServicoService(ServicoRepository servicoRepository) {
		super(servicoRepository);
		this.servicoRepository = servicoRepository;
	}

	public List<Servico> findServicos(String titulo, String descricao) {
		return servicoRepository
				.findByTituloContainingOrDescricaoContainingOrderByPatrocinadoDescMediaDescTotalDesc(titulo, descricao);
	}

	public List<Servico> findServicos(Long categoria, String texto) {
		return servicoRepository
				.findByCategoriaIdAndTituloContainingOrDescricaoContainingOrderByPatrocinadoDescMediaDescTotalDesc(
						categoria, texto, texto);
	}

	public List<Servico> findServicos(Long usuarioId) {
		return servicoRepository.findByUsuarioIdOrderByMediaDesc(usuarioId);
	}	
		
}