package br.com.hyperclass.caixaeletronico.teste;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.hyperclass.caixaeletronico.config.WebConfig;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.ContaCorrente;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.ValorDepositadoEvento;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.ValorInicialDisponibilizadoEvento;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.ValorSacadoEvento;
import br.com.hyperclass.caixaeletronico.restapi.wrapper.ExtratoWrapper;
import br.com.hyperclass.caixaeletronico.restapi.wrapper.ValorWrapper;
import br.com.hyperclass.caixaeletronico.teste.config.SpringContextConfigurationTest;
import br.com.hyperclass.caixaeletronico.teste.domain.CaixaEletronicoTest;
import br.com.hyperclass.caixaeletronico.teste.util.DefaultComparatorCaixaEletronico;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { SpringContextConfigurationTest.class, WebConfig.class })
public class CaixaControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Autowired
	private CaixaEletronicoTest caixaTest;

	@Before
	public void setup() {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		this.mockMvc = builder.build();
	}

	@Test
	public void testeExtratoContaCorrente() throws Exception {

		final ContaCorrente cc = caixaTest.getConta("12345-0");
		cc.creditar(150);
		cc.creditar(50);
		cc.sacar(150);
		
		MvcResult result = this.mockMvc.perform(get("/12345-0/extrato")).andReturn();
		JSONAssert.assertEquals(convertObjectToJson(getExtratoWraper()), result.getResponse().getContentAsString(), new DefaultComparatorCaixaEletronico("data"));
	}
	
	@Test
	public void testeSaldoContaCorrente() throws Exception{
		
		final ContaCorrente cc = caixaTest.getConta("12345-0");

		MvcResult result = this.mockMvc.perform(get("/12345-0/saldo")).andReturn();
		
		JSONAssert.assertEquals(convertObjectToJson(new ValorWrapper(412.13)), result.getResponse().getContentAsString(), true);
		
	}
	
	@Test
	public void testeDepositoContaCorrente() throws Exception{
		
		final ContaCorrente cc = caixaTest.getConta("12345-0");
		MvcResult result = this.mockMvc.perform(get("/12345-0/depositar")).andReturn();
		
		JSONAssert.assertEquals(convertObjectToJson(new ValorWrapper(412.13)), result.getResponse().getContentAsString(), true);

		
	}
	
	private ExtratoWrapper getExtratoWraper(){
		
		final List<EventoTransacional> eventosContaCorrente = new ArrayList<>(3);
		eventosContaCorrente.add(new ValorInicialDisponibilizadoEvento(412.13));
		eventosContaCorrente.add(new ValorDepositadoEvento(150));
		eventosContaCorrente.add(new ValorDepositadoEvento(50));
		eventosContaCorrente.add(new ValorSacadoEvento(150));
		
		return new ExtratoWrapper(eventosContaCorrente);
	}
	
	private String convertObjectToJson(final Object object) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
