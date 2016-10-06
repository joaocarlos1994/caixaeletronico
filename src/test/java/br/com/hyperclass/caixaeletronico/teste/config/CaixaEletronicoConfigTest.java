package br.com.hyperclass.caixaeletronico.teste.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.hyperclass.caixaeletronico.config.CaixaEletronicoConfigAbstract;
import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronico;
import br.com.hyperclass.caixaeletronico.domain.caixa.Nota;
import br.com.hyperclass.caixaeletronico.domain.caixa.ValorNota;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.ContaCorrente;
import br.com.hyperclass.caixaeletronico.teste.domain.CaixaEletronicoTest;

@Configuration
public class CaixaEletronicoConfigTest extends CaixaEletronicoConfigAbstract {

	@Bean
	@Override
	public CaixaEletronico caixaEletronico() {
		return new CaixaEletronicoTest(notasCaixa(), contasCorrentes());
	}

	@Override
	public List<ContaCorrente> contasCorrentes() {

		final ContaCorrente contaCorrente = new ContaCorrente("12345-0", 412.13);
		final ContaCorrente contaCorrente2 = new ContaCorrente("05432-1", 412.13);

		final List<ContaCorrente> contasCorrentes = new ArrayList<>(2);

		contasCorrentes.add(contaCorrente);
		contasCorrentes.add(contaCorrente2);

		return contasCorrentes;
	}

	@Override
	public Map<ValorNota, List<Nota>> notasCaixa() {
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

}
