package pl.coderslab.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderslab.spring.web.converters.UserConverter;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

@Configuration
@ComponentScan(basePackages = {"pl.coderslab.spring.web", "pl.coderslab.spring.domain.dao"})
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.coderslab.spring.domain.repositories")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("warsztat6Unit");
        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.parseMediaType("text/plain;charset=UTF-8"));
        configurer.ignoreAcceptHeader(true);
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }


    @Bean
    public UserConverter userConverter() {
        return new UserConverter();
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(userConverter());
    }


}
