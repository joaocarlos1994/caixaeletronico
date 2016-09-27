package br.com.hyperclass.caixaeletronico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronico;
import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronicoException;

@RestController
public class CaixaEletronicoController {
	
	private final CaixaEletronico caixaEletronico;
	
	@Autowired
	public CaixaEletronicoController(CaixaEletronico caixaEletronico){
		this.caixaEletronico = caixaEletronico;
	}
	
	@RequestMapping(value="{conta}/saldo}", method=RequestMethod.GET)
	public String saldo(final String contaCorrente) throws CaixaEletronicoException{
		caixaEletronico.saldo(contaCorrente);
		return null;
	}
	
	@RequestMapping(value="{conta}/sacar/{valor}}", method=RequestMethod.POST)
	public void sacar(@PathVariable("conta") final String conta, @RequestParam("valor") final double valor) throws CaixaEletronicoException{
		caixaEletronico.sacar(conta, valor);
	}
	
	@RequestMapping(value="{conta}/depositar/{valor}}", method=RequestMethod.POST)
	public void depositar(@PathVariable("conta") final String conta, @RequestParam("valor") final double valor) throws CaixaEletronicoException{
		caixaEletronico.depositar(conta, valor);
	}
	
	@RequestMapping(value="{conta}/tranferir/{valor}}", method=RequestMethod.POST)
	public void tranferir(final String contaOrigem, final String  contaDestino, final double valor) throws CaixaEletronicoException{
		caixaEletronico.transferir(contaOrigem, contaDestino, valor);
	}
	
	public void extrato(){
	}
	
}
