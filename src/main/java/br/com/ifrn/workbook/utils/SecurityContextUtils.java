package br.com.ifrn.workbook.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ifrn.workbook.model.user.UserAccount;

public class SecurityContextUtils {

	public static final UserAccount getUser() {
		return (UserAccount) SecurityContextHolder.getContext().getAuthentication().getDetails();
	}
	
}
