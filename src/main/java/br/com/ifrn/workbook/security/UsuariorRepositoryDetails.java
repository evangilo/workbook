package br.com.ifrn.workbook.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import br.com.ifrn.workbook.model.Usuario;

public class UsuariorRepositoryDetails extends User{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public UsuariorRepositoryDetails(Usuario usuario) {
		super(usuario.getEmail(), usuario.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Long getId() {
		return usuario.getId();
	}
	

	
}
