package br.com.hyperclass.caixaeletronico.restapi.wrapper;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;
import br.com.hyperclass.caixaeletronico.restapi.serializer.ExtratoSerializer;


/**
 * A classe <code>ExtratoWrapper</code> é uma classe de configuração que serializa os eventos que  
 * transacionais.
 * 
 * @author João Carlos
 * @version 1.0 30/09/2016
 * */

@JsonSerialize(using = ExtratoSerializer.class)
public class ExtratoWrapper {
	
	private final List<EventoTransacional> eventosTrasacionais;

	public ExtratoWrapper(List<EventoTransacional> eventosTrasacionais) {
		super();
		this.eventosTrasacionais = eventosTrasacionais;
	}

	public List<EventoTransacional> getEventosTrasacionais() {
		return Collections.unmodifiableList(eventosTrasacionais);
	}
	
	
	
}
