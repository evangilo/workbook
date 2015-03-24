package br.com.ifrn.workbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ifrn.workbook.model.servico.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{	
	
	List<Servico> findByTituloContainingOrDescricaoContainingOrderByPatrocinadoDescMediaDescTotalDesc(String titulo, String descricao);

	@Query("from Servico s where s.categoria.id = ?1 and (s.titulo like %?2% or s.descricao like %?3%) order by s.patrocinado desc, s.media desc, s.total desc")
	List<Servico> findByCategoriaIdAndTituloContainingOrDescricaoContainingOrderByPatrocinadoDescMediaDescTotalDesc(Long categoria, String titulo, String descricao);
	
	List<Servico> findByUsuarioIdOrderByMediaDesc(Long usuarioId);
	
	Servico findById(Long id);
	
	List<Servico> findByDescricaoContainingOrderByPatrocinadoDescMediaDescTotalDesc(String descricao);

	List<Servico> findByTituloContainingOrDescricaoContainingOrderByMediaDescTotalDesc(String titulo, String descricao);

	List<Servico> findByMedia(int media);
}
