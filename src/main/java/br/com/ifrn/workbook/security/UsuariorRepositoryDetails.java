package br.com.ifrn.workbook.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.ifrn.workbook.model.Usuario;

public class UsuariorRepositoryDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public UsuariorRepositoryDetails(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList("ROLE_USER");
	}
	
	@Override
	public String getUsername() {
		return usuario.getEmail();
	}
	
	@Override
	public String getPassword() {
		return usuario.getPassword();
	}	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
