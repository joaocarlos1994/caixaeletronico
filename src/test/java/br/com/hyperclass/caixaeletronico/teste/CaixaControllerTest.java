package br.com.hyperclass.caixaeletronico.teste;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.hyperclass.caixaeletronico.config.WebConfig;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.ContaCorrente;
import br.com.hyperclass.caixaeletronico.restapi.wrapper.ExtratoWrapper;
import br.com.hyperclass.caixaeletronico.teste.config.SpringContextConfigurationTest;
import br.com.hyperclass.caixaeletronico.teste.domain.CaixaEletronicoTest;

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
	public void jsonTest() throws Exception {

		final ContaCorrente cc = caixaTest.getConta("12345-0");
		cc.creditar(150);
		cc.creditar(50);
		cc.sacar(150);

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(new ExtratoWrapper(cc.extrato()));

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/12345-0/extrato")
				.accept(MediaType.APPLICATION_JSON);

		// final MvcResult result =
		// mockMvc.perform(get("/12345-0/extrato")).andReturn();

	}

}
