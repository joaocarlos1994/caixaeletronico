package br.com.hyperclass.caixaeletronico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan
public class RootConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

/*	@Bean
	public Validator validator() {
		final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		return factory.getValidator();
	}*/

/*	@Bean
	public ThreadPool threadPool() {
		return new ThreadPool();
	}

	@Bean
	public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
		return new SecurityEvaluationContextExtension();
	}*/

	/*@Bean
	public FreeMarkerConfigurationFactoryBean freeMarkerBean() {
		return new FreeMarkerConfigurationFactoryBean();
	}*/

}
