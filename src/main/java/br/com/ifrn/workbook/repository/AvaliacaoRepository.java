package br.com.ifrn.workbook.repository;

import java.util.List;

import br.com.ifrn.workbook.model.servico.Avaliacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Long> {
	
	List<Avaliacao> findByServico(Long servicoID);

}
