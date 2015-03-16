package br.com.ifrn.workbook.config;

import javax.inject.Inject;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.ifrn.workbook.security.CurrentUserDetailsService;
import br.com.ifrn.workbook.service.UserService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Inject
	private UserService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
		 	.csrf().disable()
		 	.headers()
		 		.cacheControl()
		 		.contentTypeOptions()
		 		.httpStrictTransportSecurity()
		 		.and()
		 	.authorizeRequests()
		 		.antMatchers("/static/**", "/connect/facebook/").permitAll()
		 		.and()
		 	.formLogin()
		 		.loginPage("/login")		 		
		 		.permitAll()
		 		.and()
		 	.logout()
		 		.permitAll();
	}		
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		auth.userDetailsService(userDetailsService())
		.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CurrentUserDetailsService(userService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
