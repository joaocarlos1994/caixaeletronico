package br.com.hyperclass.caixaeletronico.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronico;
import br.com.hyperclass.caixaeletronico.domain.caixa.Nota;
import br.com.hyperclass.caixaeletronico.domain.caixa.ValorNota;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.ContaCorrente;

public abstract class CaixaEletronicoConfigAbstract {
	
	public abstract CaixaEletronico caixaEletronico();
	public abstract List<ContaCorrente> contasCorrentes();
	public abstract Map<ValorNota, List<Nota>> notasCaixa();
	
	protected List<Nota> listaNota(final ValorNota valorNota, final int quantidade) {
		final List<Nota> notas = new ArrayList<>(quantidade);

		for (int i = 0; i < quantidade; i++) {
			notas.add(new Nota(valorNota));
		}

		return notas;
	}
	
}
