package br.com.ifrn.workbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifrn.workbook.model.local.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	List<Cidade> findByEstado(String estado);

}
