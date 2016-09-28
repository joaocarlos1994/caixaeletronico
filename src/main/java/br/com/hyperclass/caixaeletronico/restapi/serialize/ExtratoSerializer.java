package br.com.hyperclass.caixaeletronico.restapi.serialize;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos_.EventoTransacional;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos_.TipoEvento;
import br.com.hyperclass.caixaeletronico.restapi.wrapper.ExtratoWrapper;

public class ExtratoSerializer extends JsonSerializer<ExtratoWrapper> {
	
	private final Map<TipoEvento, Serializer> eventosSerializer;

	@Autowired
	public ExtratoSerializer(Map<TipoEvento, Serializer> eventosSerializer) {
		super();
		this.eventosSerializer = eventosSerializer;
	}

	@Override
	public void serialize(ExtratoWrapper extratoWrapper, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
		
		jsonGenerator.writeStartArray();
		
		for (final EventoTransacional e : extratoWrapper.getEventosTrasacionais()) {
			Serializer s = eventosSerializer.get(e.getTipo());
			s.serialize(e, jsonGenerator);
		}
		
		jsonGenerator.writeEndArray();
		
	}


}
