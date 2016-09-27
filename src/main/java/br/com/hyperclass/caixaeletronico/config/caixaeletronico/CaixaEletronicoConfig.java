package br.com.hyperclass.caixaeletronico.config.caixaeletronico;

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

@Configuration
public class CaixaEletronicoConfig {

	@Bean
	public CaixaEletronico caixaEletronico() {
		
		CaixaEletronico caixaEletronico = new CaixaEletronico(notasCaixa(), contasCorrentes());
		
		return caixaEletronico;
	}
	
	private static final List<ContaCorrente> contasCorrentes(){
		
		final ContaCorrente contaCorrente = new ContaCorrente("aaa", 1000);
		final ContaCorrente contaCorrente2 = new ContaCorrente("aaa", 1000);
		final ContaCorrente contaCorrente3 = new ContaCorrente("aaa", 1000);
		final ContaCorrente contaCorrente4 = new ContaCorrente("aaa", 1000);
		final ContaCorrente contaCorrente5 = new ContaCorrente("aaa", 1000);
		
		final List<ContaCorrente> contasCorrentes = new ArrayList<>();
		
		contasCorrentes.add(contaCorrente);
		contasCorrentes.add(contaCorrente2);
		contasCorrentes.add(contaCorrente3);
		contasCorrentes.add(contaCorrente4);
		contasCorrentes.add(contaCorrente5);
		
		
		return contasCorrentes;
	}

	private static final Map<ValorNota, List<Nota>> notasCaixa() {
		
		final Map<ValorNota, List<Nota>> notasCaixa = new HashMap<>();
		
		notasCaixa.put(ValorNota.UM, listaNota1(10));
		notasCaixa.put(ValorNota.DOIS, listaNota2(10));
		notasCaixa.put(ValorNota.CINCO, listaNota5(10));
		notasCaixa.put(ValorNota.DEZ, listaNota10(10));
		notasCaixa.put(ValorNota.VINTE, listaNota20(10));
		notasCaixa.put(ValorNota.CINQUENTA, listaNota50(10));
		notasCaixa.put(ValorNota.CEM, listaNota100(10));

		return notasCaixa;
	}

	private static final List<Nota> listaNota1(final int quantidade) {

		final List<Nota> notas1 = new ArrayList<>();

		for (int i = 0; i < quantidade; i++) {
			notas1.add(new Nota(ValorNota.UM));
		}

		return notas1;
	}

	private static final List<Nota> listaNota2(final int quantidade) {

		final List<Nota> notas2 = new ArrayList<>();

		for (int i = 0; i < quantidade; i++) {
			notas2.add(new Nota(ValorNota.DOIS));
		}

		return notas2;

	}

	private static final List<Nota> listaNota5(final int quantidade) {

		final List<Nota> notas5 = new ArrayList<>();

		for (int i = 0; i < quantidade; i++) {
			notas5.add(new Nota(ValorNota.CINCO));
		}

		return notas5;

	}

	private static final List<Nota> listaNota10(final int quantidade) {

		final List<Nota> notas10 = new ArrayList<>();

		for (int i = 0; i < quantidade; i++) {
			notas10.add(new Nota(ValorNota.DEZ));
		}

		return notas10;
	}

	private static final List<Nota> listaNota20(final int quantidade) {

		final List<Nota> notas20 = new ArrayList<>();

		for (int i = 0; i < quantidade; i++) {
			notas20.add(new Nota(ValorNota.VINTE));
		}

		return notas20;

	}

	private static final List<Nota> listaNota50(final int quantidade) {
		final List<Nota> notas50 = new ArrayList<>();

		for (int i = 0; i < quantidade; i++) {
			notas50.add(new Nota(ValorNota.CINQUENTA));
		}

		return notas50;
	}

	private static final List<Nota> listaNota100(final int quantidade) {
		final List<Nota> notas100 = new ArrayList<>();

		for (int i = 0; i < quantidade; i++) {
			notas100.add(new Nota(ValorNota.CEM));
		}

		return notas100;
	}

}
