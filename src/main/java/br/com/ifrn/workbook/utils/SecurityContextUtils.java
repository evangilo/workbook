package br.com.ifrn.workbook.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.ifrn.workbook.model.user.UserAccount;
import br.com.ifrn.workbook.service.UserService;

@Component
public class SecurityContextUtils {

	public static UserAccount getUser(UserService userService) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) return userService.getByEmail(auth.getName());
		throw new IllegalStateException("Nenhum usuário logado!");
	}	
	
}
