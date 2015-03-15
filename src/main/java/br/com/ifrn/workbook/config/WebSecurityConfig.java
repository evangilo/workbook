package br.com.ifrn.workbook.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

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
	
	@Inject
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user").password("user").roles("USER").and()
			.withUser("admin").password("admin").roles("USER", "ADMIN");
	}

}
