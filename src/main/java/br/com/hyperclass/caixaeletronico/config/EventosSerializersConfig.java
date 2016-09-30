package br.com.hyperclass.caixaeletronico.config;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.TipoEvento;
import br.com.hyperclass.caixaeletronico.restapi.serializer.Serializer;

/**
 * A classe <code>EventosSerializersConfig</code> é uma classe de configuração contendo
 * a configuração dos Serializer do caixa eletrônico.
 * 
 * @author João Carlos
 * @version 1.0 28/09/2016
 */

@Configuration
public class EventosSerializersConfig {

	@Autowired
	@Qualifier("defaultSerializer")
	private Serializer defaultSerializer;

	@Autowired
	@Qualifier("transferenciaSerializer")
	private Serializer transferenciaSerializer;

	
	/**
	 * O metodo eventosSerializer retorna um map com a configuração de todos Beans
	 * dispovível na aplicação.
	 * */
	@Bean
	public Map<TipoEvento, Serializer> eventosSerializer() {
		final Map<TipoEvento, Serializer> map = new EnumMap<>(TipoEvento.class);

		map.put(TipoEvento.SALDO_INICIAL, defaultSerializer);
		map.put(TipoEvento.SAQUE, defaultSerializer);
		map.put(TipoEvento.DEPOSITO, defaultSerializer);
		map.put(TipoEvento.TRANSFERENCIA_ENTRADA, transferenciaSerializer);
		map.put(TipoEvento.TRANSFERENCIA_SAIDA, transferenciaSerializer);

		return map;
	}
}