package br.com.hyperclass.caixaeletronico.restapi.serialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos_.EventoTransacional;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos_.ValorTransferidoEvento;

/**
 * A classe <code>TransferenciaSerializer</code> contém a operação de serializar
 * um objeto evento transacional do tipo transferência.
 * 
 * @author João Carlos
 * @version 1.0 28/09/2016
 * */

public class TransferenciaSerializer extends DefaultSerializer {
	
	@Override
	public void serialize(EventoTransacional evTransacional, JsonGenerator jsonGenerator) throws IOException {
		
		jsonGenerator.writeStartObject();
		
		super.serialize(evTransacional, jsonGenerator);
		
		ValorTransferidoEvento ev = (ValorTransferidoEvento) evTransacional;
		jsonGenerator.writeStringField("conta", ev.getSource().getConta().getNumeroConta());
		
		jsonGenerator.writeEndObject();
	}

}
