package br.com.hyperclass.caixaeletronico.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CaixaEletronicoConfig.class)
public class RootConfig {
}