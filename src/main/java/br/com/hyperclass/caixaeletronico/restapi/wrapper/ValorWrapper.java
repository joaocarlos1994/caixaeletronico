package br.com.hyperclass.caixaeletronico.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.caixaeletronico.restapi.deserializer.ValorDeserializer;
import br.com.hyperclass.caixaeletronico.restapi.serializer.ValorSerializer;

/**
 * A classe <code>ValorWrapper</code> é uma classe de configuração de serializar um valor.
 * 
 * @author João Carlos
 * @version 1.0 30/09/2016
 * */

@JsonSerialize(using = ValorSerializer.class)
@JsonDeserialize(using = ValorDeserializer.class)
public class ValorWrapper {
	
	private final double valor;

	public ValorWrapper(double valor) {
		super();
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
	
	
	
}
