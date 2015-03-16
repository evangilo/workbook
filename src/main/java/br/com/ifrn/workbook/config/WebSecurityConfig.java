package br.com.ifrn.workbook.config;

import javax.inject.Inject;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.ifrn.workbook.repository.CurrentUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Inject
	private CurrentUserDetailsService usuarioDetailsService;

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
		auth.userDetailsService(usuarioDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
