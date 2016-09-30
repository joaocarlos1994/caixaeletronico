package br.com.hyperclass.caixaeletronico.restapi.serializer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.ValorTransferidoEvento;

/**
 * A classe <code>TransferenciaSerializer</code> contém a operação de serializar
 * um objeto evento transacional do tipo transferência.
 * 
 * @author João Carlos
 * @version 1.0 28/09/2016
 * */
@Component
@Qualifier("transferenciaSerializer")
public class TransferenciaSerializer extends DefaultSerializer {
	
	@Override
	public void serialize(EventoTransacional evTransacional, JsonGenerator jsonGenerator) throws IOException {
		
		jsonGenerator.writeStartObject();
		
		super.serializerDefaultValues(evTransacional, jsonGenerator);
		
		ValorTransferidoEvento ev = (ValorTransferidoEvento) evTransacional;
		jsonGenerator.writeStringField("conta", ev.getNumeroConta());
		
		jsonGenerator.writeEndObject();
	}

}
