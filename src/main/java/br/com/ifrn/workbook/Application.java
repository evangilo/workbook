package br.com.ifrn.workbook;

import javax.persistence.EntityManager;

import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){        
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }    

    @Bean
    public EntityManager entityManager(HibernateEntityManagerFactory hemf) {
    	return hemf.createEntityManager();
    }
    
    public static void main(String[] args)  {
    	SpringApplication.run(Application.class, args);
    }
    
} 