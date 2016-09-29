package br.com.hyperclass.caixaeletronico.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronico;
import br.com.hyperclass.caixaeletronico.domain.caixa.Nota;
import br.com.hyperclass.caixaeletronico.domain.caixa.ValorNota;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.ContaCorrente;

/**
 * A classe <code>CaixaEletronicoConfig</code> é uma classe de configuração, contendo a
 * configuração das notas disponívei e os clientes existentes na aplicação.
 *
 * @author João Carlos
 * @version 1.0 28/09/2016
 */

@Configuration
public class CaixaEletronicoConfig {

	@Bean
	public CaixaEletronico caixaEletronico() {
		return new CaixaEletronico(notasCaixa(), contasCorrentes());
	}

	private List<ContaCorrente> contasCorrentes() {
		final ContaCorrente contaCorrente = new ContaCorrente("54125-9", 10854.78);
		final ContaCorrente contaCorrente2 = new ContaCorrente("25214-8", 1050.99);
		final ContaCorrente contaCorrente3 = new ContaCorrente("88452-1", 7696.00);
		final ContaCorrente contaCorrente4 = new ContaCorrente("15935-7", 412.13);

		final List<ContaCorrente> contasCorrentes = new ArrayList<>(4);

		contasCorrentes.add(contaCorrente);
		contasCorrentes.add(contaCorrente2);
		contasCorrentes.add(contaCorrente3);
		contasCorrentes.add(contaCorrente4);

		return contasCorrentes;
	}

	private Map<ValorNota, List<Nota>> notasCaixa() {

		final Map<ValorNota, List<Nota>> notasCaixa = new HashMap<>();

		notasCaixa.put(ValorNota.UM, listaNota(ValorNota.UM, 10));
		notasCaixa.put(ValorNota.DOIS, listaNota(ValorNota.DOIS, 10));
		notasCaixa.put(ValorNota.CINCO, listaNota(ValorNota.CINCO, 10));
		notasCaixa.put(ValorNota.DEZ, listaNota(ValorNota.DEZ, 10));
		notasCaixa.put(ValorNota.VINTE, listaNota(ValorNota.VINTE, 10));
		notasCaixa.put(ValorNota.CINQUENTA, listaNota(ValorNota.CINQUENTA, 10));
		notasCaixa.put(ValorNota.CEM, listaNota(ValorNota.CEM, 10));

		return notasCaixa;
	}

	private List<Nota> listaNota(final ValorNota valorNota, final int quantidade) {
		final List<Nota> notas = new ArrayList<>(quantidade);

		for (int i = 0; i < quantidade; i++) {
			notas.add(new Nota(valorNota));
		}

		return notas;
	}
}