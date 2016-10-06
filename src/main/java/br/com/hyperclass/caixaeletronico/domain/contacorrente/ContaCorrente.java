/*
 * @(#)ContaCorrente.java 1.0 23/09/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */

package br.com.hyperclass.caixaeletronico.domain.contacorrente;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronicoException;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.TipoEvento;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.ValorDepositadoEvento;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.ValorInicialDisponibilizadoEvento;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.ValorSacadoEvento;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.ValorTransferidoEvento;

/**
 * A classe <code>ContaCorrente</code> representa uma conta corrente. N�o h� um
 * campo <code>saldo</code>; em vez disso, h� uma lista de eventos que ocorreram
 * na conta, e o saldo � calculado a partir do c�lculo de todos os eventos
 * presentes na lista.
 *
 * @author Roberto Perillo
 * @version 1.0 23/09/2016
 */
public class ContaCorrente {

	private final String numeroConta;
	private final List<EventoTransacional> historico = new LinkedList<>();

	public ContaCorrente(final String numeroConta, final double saldoInicial) {
		super();
		this.numeroConta = numeroConta;
		historico.add(new ValorInicialDisponibilizadoEvento(saldoInicial));
	}

	public double saldo() {
		double saldo = 0.0;
		for (final EventoTransacional evento : historico) {
			saldo = evento.atualizarSaldo(saldo);
		}
		return saldo;
	}

	public List<EventoTransacional> extrato() {
		Collections.sort(historico);
		return Collections.unmodifiableList(historico);
	}

	public void creditar(final double valor) {
		historico.add(new ValorDepositadoEvento(valor));
	}

	public void sacar(final double valor) throws CaixaEletronicoException {
		if (!temSaldo(valor)) {
			throw new SaldoInsuficienteException(saldo());
		}
		historico.add(new ValorSacadoEvento(valor));
	}

	public void transferir(final ContaCorrente contaDestino, final double valor) throws CaixaEletronicoException {
		if (!temSaldo(valor)) {
			throw new SaldoInsuficienteException(saldo());
		}
		historico.add(new ValorTransferidoEvento(contaDestino, valor, TipoEvento.TRANSFERENCIA_SAIDA));
		contaDestino.receberTransferencia(this, valor);
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	private boolean temSaldo(final double valor) {
		return saldo() >= valor;
	}

	private void receberTransferencia(final ContaCorrente contaOrigem, final double valor) {
		historico.add(new ValorTransferidoEvento(contaOrigem, valor, TipoEvento.TRANSFERENCIA_ENTRADA));
	}
}