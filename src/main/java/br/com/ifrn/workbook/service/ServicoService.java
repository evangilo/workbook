package br.com.ifrn.workbook.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.ifrn.workbook.model.servico.Avaliacao;
import br.com.ifrn.workbook.model.servico.Servico;
import br.com.ifrn.workbook.repository.AvaliacaoRepository;
import br.com.ifrn.workbook.repository.ServicoRepository;

@Service
public class ServicoService extends BaseService<Servico, Long> {
	private final ServicoRepository servicoRepository;
	private final AvaliacaoRepository avaliacaoRepository;

	@Inject
	public ServicoService(JpaRepository<Servico, Long> repository,
			ServicoRepository servicoRepository,
			AvaliacaoRepository avaliacaoRepository) {
		super(repository);
		this.servicoRepository = servicoRepository;
		this.avaliacaoRepository = avaliacaoRepository;
	} 

	public List<Servico> findServicos(String descricao) {
		return servicoRepository
				.findByDescricaoContainingOrderByPatrocinadoDescMediaDescTotalDesc(descricao);
	}
	
	public List<Servico> findServicos(String titulo, String descricao) {
		//return servicoRepository.findByTituloContainingOrDescricaoContainingOrderByPatrocinadoDescMediaDescTotalDesc(titulo, descricao);
		return servicoRepository.findByTituloContainingOrDescricaoContainingOrderByPatrocinadoDescMediaDescTotalDesc(titulo, descricao);
	}

	public List<Servico> findServicos(Long categoria, String texto) {
		return servicoRepository
				.findByCategoriaIdAndTituloContainingOrDescricaoContainingOrderByPatrocinadoDescMediaDescTotalDesc(
						categoria, texto, texto);
	}

	public List<Servico> findServicos(Long usuarioId) {
		return servicoRepository.findByUsuarioIdOrderByMediaDesc(usuarioId);
	}	
	
	public int getMediaAvaliacoes(Long servicoID){
		List<Avaliacao> avaliacoes = avaliacaoRepository.findByServicoId(servicoID);
		int total = 0;
		for (Avaliacao avaliacao : avaliacoes) {
			total+= (int) avaliacao.getNota();
		}
		return (int)total/avaliacoes.size();
			
	}
	
	public int getTotalAvaliacoes(Long servicoID){
		List<Avaliacao> avaliacoes = avaliacaoRepository.findByServicoId(servicoID);
		return avaliacoes.size();		
	}
	
	public Servico getServicoPorID(Long id){
		return servicoRepository.findById(id);
	}

	public List<Servico> findServicosPorAvaliacao(int avaliacao) {
		return servicoRepository.findByMedia(avaliacao);
	}
	
}
