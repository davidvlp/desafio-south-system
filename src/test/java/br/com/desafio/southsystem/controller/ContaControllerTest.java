package br.com.desafio.southsystem.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContaControllerTest {

 @Autowired
 private MockMvc mockMvc;
 
 @Autowired
 ObjectMapper objectMapper;
 
 private final String URI = "/conta";
 
 @Test
 public void buscarTodasContasTest() throws Exception {
  mockMvc
   .perform(get(URI))
   .andExpect(status()
     .isOk());
 }
 
 
 @Test
 public void buscarContaPeloIDTest() throws Exception {
	 mockMvc
	 .perform(get(URI + "/1"))
	 		 .andExpect(status()
	 				 .isOk())
	 		 .andDo(print()); 
 }
 
 
 @Test
 public void buscarContaPeloIdErroTest() throws Exception {
	 mockMvc
	 .perform(get(URI + "/999"))
	 .andExpect(status()
			 .isNotFound());
 }
 
 
  
}