package br.com.hyperclass.caixaeletronico.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.caixaeletronico.restapi.deserializer.ValorDeserializer;
import br.com.hyperclass.caixaeletronico.restapi.serializer.ValorSerializer;

/**
 * A classe <code>ValorWrapper</code> contém apenas um atributo do tipo double
 * que necessário ser instância, nela contém as anotações @JsonSerialize e @JsonDeserialize
 * para fazer a serilização e deserialização de um objeto.
 * 
 * @author João Carlos
 * @version 1.0 28/09/2016
 **/

/*
 * ValorWrapper
 * 
 * 
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
