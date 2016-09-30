package br.com.hyperclass.caixaeletronico.restapi.serializer;


import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.caixaeletronico.restapi.wrapper.ValorWrapper;

/**
 * A classe <code>ValorSerializer</code> contém a operação de serializar
 * um objeto valor.
 * 
 * @author João Carlos
 * @version 1.0 30/09/2016
 * */

public class ValorSerializer extends JsonSerializer<ValorWrapper> {

	@Override
	public void serialize(ValorWrapper valorWrapper, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		
		jsonGenerator.writeStartObject();
		jsonGenerator.writeNumberField("valor", valorWrapper.getValor());
        jsonGenerator.writeEndObject();
		
	}


}
