package br.com.ifrn.workbook.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.ifrn.workbook.model.user.UserAccount;
import br.com.ifrn.workbook.security.CurrentUser;
import br.com.ifrn.workbook.service.UserService;

@Component
public class SecurityContextUtils {

	public static boolean isAuthenticated() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return (!(auth instanceof AnonymousAuthenticationToken));
	}
	
	public static CurrentUser getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return (CurrentUser) auth.getPrincipal();
	}
	
	public static UserAccount getUser(UserService userService) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) return userService.getByEmail(auth.getName());
		throw new IllegalStateException("Nenhum usuário logado!");
	}	
	
}
