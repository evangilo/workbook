package br.com.ifrn.workbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ifrn.workbook.model.servico.Destaque;

public interface DestaqueRepository extends JpaRepository<Destaque, Long> {

	@Query(value = "SELECT d FROM Destaque d WHERE d.servico.id_servico IN (SELECT s.id_servico FROM Servico s WHERE s.usuario = ?0)", nativeQuery = true)
	List<Destaque> findAllUserServicos(Long usuarioId);
	
}
