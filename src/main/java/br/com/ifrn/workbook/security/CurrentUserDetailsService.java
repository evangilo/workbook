package br.com.ifrn.workbook.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ifrn.workbook.model.UserAccount;
import br.com.ifrn.workbook.service.UserService;

@Service
public class CurrentUserDetailsService implements UserDetailsService {
	
	private final UserService service;
	
	@Inject
	public CurrentUserDetailsService(UserService userService) {
		this.service = userService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserAccount user = service.getByEmail(email);
		if (user != null) {
			return new CurrentUser(user);
		}
		throw new UsernameNotFoundException(String.format("Não foi encontrado usuário com email=%s", email));
	}
		
}
