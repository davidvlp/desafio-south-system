package br.com.desafio.southsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.southsystem.dto.ContaDTO;
import br.com.desafio.southsystem.model.Conta;
import br.com.desafio.southsystem.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	ContaService contaService;
	
	@GetMapping
	public ResponseEntity<?> buscarContas(){
		List<ContaDTO> contas = contaService.listarContas();
		
		return ResponseEntity.status(HttpStatus.OK).body(contas);
	} 
	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPessoa(@PathVariable Long id){
		Conta conta = contaService.buscarContaPorID(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(conta);
	} 
	
	
	
}
