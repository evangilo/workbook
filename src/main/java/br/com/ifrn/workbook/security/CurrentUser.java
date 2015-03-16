package br.com.ifrn.workbook.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import br.com.ifrn.workbook.model.UserAccount;


public class CurrentUser extends User{

	private static final long serialVersionUID = 1L;
	
	private UserAccount user;
	
	public CurrentUser(UserAccount user) {
		super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}
	
	public UserAccount getUser() {
		return user;
	}
	
	public Long getId() {
		return user.getId();
	}
	

	
}
