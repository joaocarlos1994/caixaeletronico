package br.com.hyperclass.caixaeletronico.teste.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("br.com.hyperclass.caixaeletronico.util")
@Import(CaixaEletronicoConfigTest.class)
public class SpringContextConfigurationTest {

}
