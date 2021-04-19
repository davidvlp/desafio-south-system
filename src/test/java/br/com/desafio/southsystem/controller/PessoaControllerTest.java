package br.com.desafio.southsystem.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.desafio.southsystem.model.Pessoa;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PessoaControllerTest {

 @Autowired
 private MockMvc mockMvc;
 
 @Autowired
 ObjectMapper objectMapper;
 
 private final String URI = "/pessoa";
 
 @Test
 public void buscarTodasPessoasTest() throws Exception {
  mockMvc
   .perform(get(URI))
   .andExpect(status()
     .isOk());
 }
 
 
 @Test
 public void buscarPessoaPeloIDTest() throws Exception {
	 mockMvc
	 .perform(get(URI + "/1"))
	 		 .andExpect(status()
	 				 .isOk());
 }
 
 
 
 @Test
 public void salvarPessoaTest() throws Exception {
	 mockMvc
	 	.perform(post(URI)
	 			.content(objectMapper.writeValueAsString(this.umaPessoa()))
	 			.contentType(MediaType.APPLICATION_JSON))
	 			.andExpect(status()
	 					.isCreated()); 	
 }
 
 @Test
 public void salvarListaPessoaTest() throws Exception {
	 List<Pessoa> pessoas = Arrays.asList(this.umaPessoa());
	 mockMvc
	 	.perform(post(URI +"/cadastrarPessoas")
	 			.content(objectMapper.writeValueAsString(pessoas))
	 			.contentType(MediaType.APPLICATION_JSON))
	 			.andExpect(status()
	 					.isCreated()); 	
 }
 
 @Test
 public void buscarPessoaPeloIdErro() throws Exception {
	 mockMvc
	 .perform(get(URI + "/999"))
	 .andExpect(status()
			 .isNotFound());
 }
 
 private Pessoa umaPessoa() {
	 Pessoa p = new Pessoa();
	 p.setNome("Pessoa Teste");
	 p.setTipoPessoa("Barl");
	 p.setNumDocumento("5554545554848");
	
	 return p;
 }
 
  
}