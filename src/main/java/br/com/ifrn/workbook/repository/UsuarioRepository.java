package br.com.ifrn.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifrn.workbook.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findOneByEmail(String email);

}
