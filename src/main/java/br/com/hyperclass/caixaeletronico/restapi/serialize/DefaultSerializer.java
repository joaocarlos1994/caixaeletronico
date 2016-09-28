package br.com.hyperclass.caixaeletronico.restapi.serialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos_.EventoTransacional;

/**
 * A classe <code>DefaultSerializer</code> tem a responsabilidade fazer
 * serialização de valores default, implementando a interface Serializer.
 * 
 * @author João Carlos
 * @version 1.0 28/09/2016
 */

public class DefaultSerializer implements Serializer {

	protected void serializerDefaultValues(final EventoTransacional evTransacional, JsonGenerator jsonGenerator) throws IOException {

		jsonGenerator.writeNumberField("data", evTransacional.getData().getTime());
		jsonGenerator.writeObjectField("operacao", evTransacional.getTipo());
		jsonGenerator.writeNumberField("valor", evTransacional.getValor());

	}

	@Override
	public void serialize(EventoTransacional evTransacional, JsonGenerator jsonGenerator) throws IOException {
		jsonGenerator.writeStartObject();
		serializerDefaultValues(evTransacional, jsonGenerator);
		jsonGenerator.writeEndObject();
	}

}
