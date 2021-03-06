package br.com.hyperclass.caixaeletronico.restapi.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.hyperclass.caixaeletronico.restapi.wrapper.ValorWrapper;

/**
 * A classe <code>ValorDeserializer</code> � uma classe que fara a deseriliza��o de um valor
 * enviado atrav�s de um Json.
 * 
 * @author Jo�o Carlos
 * @version 1.0 30/09/2016
 */

public class ValorDeserializer extends JsonDeserializer<ValorWrapper> {

	@Override
	public ValorWrapper deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		
		 ObjectCodec oc = jsonParser.getCodec(); 
		 JsonNode node = oc.readTree(jsonParser);
		 
		return new ValorWrapper(node.get("valor").asDouble());
	}



}
