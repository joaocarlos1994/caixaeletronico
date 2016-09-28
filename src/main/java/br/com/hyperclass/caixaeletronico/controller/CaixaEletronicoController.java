package br.com.hyperclass.caixaeletronico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronico;
import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronicoException;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos_.EventoTransacional;


/**
 * A classe <code>CaixaEletronicoController</code> contém as rotas de transações
 * financeiras disponíveis na aplicação. Cada operação atua sobre uma conta
 * corrente específica, dado o seu número em cada operação.
 *
 * @author João Carlos
 * @version 1.0 28/09/2016
 */


@RestController
public class CaixaEletronicoController {
	
	private CaixaEletronico caixaEletronico;
	
	@Autowired
	public CaixaEletronicoController(final CaixaEletronico caixaEletronico){
		this.caixaEletronico = caixaEletronico;
	}
	
	@RequestMapping(value="/{contaCorrente}/saldo", method=RequestMethod.GET)
	public double saldo(@PathVariable final String contaCorrente) throws CaixaEletronicoException{
		return caixaEletronico.saldo(contaCorrente);
	}
	
	@RequestMapping(value="/{contaCorrente}/sacar/{valor}", method=RequestMethod.POST)
	public void sacar(@PathVariable("contaCorrente") final String conta, @PathVariable("valor") final double valor) throws CaixaEletronicoException{
		caixaEletronico.sacar(conta, valor);
	}
	
	@RequestMapping(value="/{contaCorrente}/depositar", method=RequestMethod.POST)
	public void depositar(@PathVariable final String conta, @RequestParam("valor") final double valor) throws CaixaEletronicoException{
		caixaEletronico.depositar(conta, valor);
	}
	
	@RequestMapping(value="/{contaCorrente}/tranferir", method=RequestMethod.POST)
	public void tranferir(final String contaOrigem, final String  contaDestino, final double valor) throws CaixaEletronicoException{
		caixaEletronico.transferir(contaOrigem, contaDestino, valor);
	}
	
	@RequestMapping(value="/{contaCorrente}/tranferir", method=RequestMethod.GET)
	public List<EventoTransacional> extrato(@PathVariable final String conta){
		return caixaEletronico.extrato(conta);
	}
	
}
