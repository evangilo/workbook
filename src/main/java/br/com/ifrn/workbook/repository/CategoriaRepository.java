package br.com.ifrn.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifrn.workbook.model.servico.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
