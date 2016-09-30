package br.com.hyperclass.caixaeletronico.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.hyperclass.caixaeletronico.restapi.deserializer.TransferenciaDeserializer;

/**
 * A classe <code>TransferenciaWrapper</code> contém a operação de serializar uma 
 * lista de eventos transacionais.
 * 
 * @author João Carlos
 * @version 1.0 30/09/2016
 * */

@JsonDeserialize(using = TransferenciaDeserializer.class)
public class TransferenciaWrapper {
	
	private final double valor;
	private final String contaDestino;
	
	public TransferenciaWrapper(double valor, String contaDestino) {
		super();
		this.valor = valor;
		this.contaDestino = contaDestino;
	}

	public double getValor() {
		return valor;
	}

	public String getContaDestino() {
		return contaDestino;
	}

}
