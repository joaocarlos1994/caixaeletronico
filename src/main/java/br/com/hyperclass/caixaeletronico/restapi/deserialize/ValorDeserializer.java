package br.com.hyperclass.caixaeletronico.restapi.deserialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.hyperclass.caixaeletronico.restapi.wrapper.ValorWrapper;

public class ValorDeserializer extends JsonDeserializer<ValorWrapper> {

	@Override
	public ValorWrapper deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		
		 ObjectCodec oc = jsonParser.getCodec(); 
		 JsonNode node = oc.readTree(jsonParser);
		 
		 final double valor = 0;
	        
		return new ValorWrapper(valor);
	}



}
