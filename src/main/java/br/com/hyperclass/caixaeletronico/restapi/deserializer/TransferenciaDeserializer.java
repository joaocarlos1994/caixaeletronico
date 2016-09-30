package br.com.hyperclass.caixaeletronico.restapi.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.hyperclass.caixaeletronico.restapi.wrapper.TransferenciaWrapper;

/**
 * A classe <code>TransferenciaDeserializer</code> é uma classe que fara a deserilização de um Json que
 * contenha as propriedades valor e contadestino.
 * 
 * @author João Carlos
 * @version 1.0 30/09/2016
 */

public class TransferenciaDeserializer extends JsonDeserializer<TransferenciaWrapper> {

	@Override
	public TransferenciaWrapper deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		
		ObjectCodec oc = jsonParser.getCodec(); 
		 JsonNode node = oc.readTree(jsonParser);
		
		return new TransferenciaWrapper(node.get("valor").asDouble(), node.get("contadestino").asText());
	}

}
