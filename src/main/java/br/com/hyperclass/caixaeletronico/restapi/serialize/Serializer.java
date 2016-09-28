package br.com.hyperclass.caixaeletronico.restapi.serialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos_.EventoTransacional;

/**
 * A interface <code>Serializer</code> contém um método de serializar
 * um objeto evento transacional.
 * 
 * @author João Carlos
 * @version 1.0 28/09/2016
 * */

public interface Serializer {
	
	public void serialize(final EventoTransacional evTransacional, JsonGenerator jsonGenerator) throws IOException;
	
}
