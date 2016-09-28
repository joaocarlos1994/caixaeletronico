package br.com.hyperclass.caixaeletronico.restapi.serialize;


import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.caixaeletronico.restapi.wrapper.ValorWrapper;

public class ValorSerializer extends JsonSerializer<ValorWrapper> {

	@Override
	public void serialize(ValorWrapper valorWrapper, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		
		jsonGenerator.writeStartObject();
		jsonGenerator.writeNumberField("valor", valorWrapper.getValor());
        jsonGenerator.writeEndObject();
		
	}


}
