package br.com.hyperclass.caixaeletronico.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronico;
import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronicoException;
import br.com.hyperclass.caixaeletronico.restapi.wrapper.ExtratoWrapper;
import br.com.hyperclass.caixaeletronico.restapi.wrapper.TransferenciaWrapper;
import br.com.hyperclass.caixaeletronico.restapi.wrapper.ValorWrapper;


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
	public ValorWrapper saldo(@PathVariable final String contaCorrente) throws CaixaEletronicoException{
		return new ValorWrapper(caixaEletronico.saldo(contaCorrente));
	}
	
	@RequestMapping(value="/{contaCorrente}/sacar", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void sacar(@PathVariable("contaCorrente") final String conta, @RequestBody final ValorWrapper valorWrapper) throws CaixaEletronicoException{
		caixaEletronico.sacar(conta, valorWrapper.getValor());
	}
	
	@RequestMapping(value="/{contaCorrente}/depositar", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void depositar(@PathVariable("contaCorrente") final String conta, @RequestBody final ValorWrapper valorWrapper) throws CaixaEletronicoException{
		caixaEletronico.depositar(conta, valorWrapper.getValor());
	}
	
	@RequestMapping(value="/{contaCorrente}/transferir", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void tranferir(@PathVariable("contaCorrente") final String contaOrigem, @RequestBody final TransferenciaWrapper  transferenciaWrapper) throws CaixaEletronicoException{
		caixaEletronico.transferir(contaOrigem, transferenciaWrapper.getContaDestino(), transferenciaWrapper.getValor());
	}
	
	@RequestMapping(value="/{contaCorrente}/extrato", method=RequestMethod.GET)
	public ExtratoWrapper extrato(@PathVariable("contaCorrente") final String contaCorrente){
		return new ExtratoWrapper(caixaEletronico.extrato(contaCorrente));
	}
	
}
