package br.com.ifrn.workbook.repository;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ifrn.workbook.model.Usuario;
import br.com.ifrn.workbook.security.UsuariorRepositoryDetails;
import br.com.ifrn.workbook.service.usuario.UsuarioService;

@Service
public class CurrentUserDetailsService implements UserDetailsService {
	
	private final UsuarioService service;
	
	@Inject
	public CurrentUserDetailsService(UsuarioService usuarioService) {
		this.service = usuarioService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = service.getByEmail(email);
		if (usuario != null) {
			return new UsuariorRepositoryDetails(usuario);
		}
		throw new UsernameNotFoundException(String.format("Não foi encontrado usuário com email=%s", email));
	}
		
}
