package br.com.ifrn.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ifrn.workbook.model.servico.Categoria;
import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	@Query(value = "select distinct c.* from categoria c left join servico s on s.categoria = c.id_categoria where s.usuario = ?", nativeQuery = true)
	List<Categoria> findByUser(Long userId);

	@Query(value = "select distinct c.* from categoria c left outer join servico s on s.categoria = c.id_categoria where s.categoria = c.id_categoria", nativeQuery = true)
	List<Categoria> findCategoriasWithServicos();
}
