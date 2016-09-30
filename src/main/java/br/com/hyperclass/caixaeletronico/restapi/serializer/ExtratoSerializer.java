package br.com.hyperclass.caixaeletronico.restapi.serializer;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.TipoEvento;
import br.com.hyperclass.caixaeletronico.restapi.wrapper.ExtratoWrapper;

/**
 * A classe <code>ExtratoSerializer</code> é uma classe que fara a serilização de um Json. Ela
 * contém um map de serializadores.
 * 
 * @author João Carlos
 * @version 1.0 30/09/2016
 */

public class ExtratoSerializer extends JsonSerializer<ExtratoWrapper> {
	
	private final Map<TipoEvento, Serializer> eventosSerializer = new EnumMap<>(TipoEvento.class);

	@Override
	public void serialize(ExtratoWrapper extratoWrapper, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider) throws IOException {
		
		jsonGenerator.writeStartArray();
		
		for (final EventoTransacional e : extratoWrapper.getEventosTrasacionais()) {
			Serializer s = eventosSerializer.get(e.getTipo());
			s.serialize(e, jsonGenerator);
		}
		
		jsonGenerator.writeEndArray();
		
	}
	
	@Resource
	public void setEventosSerializer(final Map<TipoEvento, Serializer> eventosSerializer){
		this.eventosSerializer.putAll(eventosSerializer);
	}
}