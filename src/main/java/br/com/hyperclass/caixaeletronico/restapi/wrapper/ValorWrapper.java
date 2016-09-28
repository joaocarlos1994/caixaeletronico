package br.com.hyperclass.caixaeletronico.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.caixaeletronico.restapi.deserialize.ValorDeserializer;
import br.com.hyperclass.caixaeletronico.restapi.serialize.ValorSerializer;

/**
 * A classe <code>ValorWrapper</code> cont�m apenas um atributo do tipo double
 * que necess�rio ser inst�ncia, nela cont�m as anota��es @JsonSerialize e @JsonDeserialize
 * para fazer a seriliza��o e deserializa��o de um objeto.
 * 
 * @author Jo�o Carlos
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
