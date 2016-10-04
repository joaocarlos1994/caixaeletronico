package br.com.hyperclass.caixaeletronico.teste.domain;

import java.util.List;
import java.util.Map;

import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronico;
import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronicoException;
import br.com.hyperclass.caixaeletronico.domain.caixa.Nota;
import br.com.hyperclass.caixaeletronico.domain.caixa.ValorNota;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.ContaCorrente;

public class CaixaEletronicoTest extends CaixaEletronico {

	public CaixaEletronicoTest(Map<ValorNota, List<Nota>> notas, List<ContaCorrente> correntistas) {
		super(notas, correntistas);
		// TODO Auto-generated constructor stub
	}

	public ContaCorrente getConta(final String conta) throws CaixaEletronicoException {
		return getContaCorrente(conta);
	}

}
