package br.com.ifrn.workbook.config;

import javax.inject.Inject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.ifrn.workbook.repository.UsuarioRepositoryUserDetailsService;

@Configuration
@EnableWebMvcSecurity
//@ComponentScan(basePackageClasses=UsuarioRepositoryUserDetailsService.class)
//@EnableGlobalMethodSecurity(prePostEnabled = true)
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
	public void configureGlobal(UsuarioRepositoryUserDetailsService userDetailsService, AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ROLE_USER", "ROLE_ADMIN");
		auth.userDetailsService(userDetailsService);
	}

}
