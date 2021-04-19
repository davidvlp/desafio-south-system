package br.com.desafio.southsystem.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.southsystem.dto.PessoaDTO;
import br.com.desafio.southsystem.model.Pessoa;
import br.com.desafio.southsystem.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<?> buscarPessoas() {
		List<PessoaDTO> pessoas = pessoaService.listarPessoa();

		return ResponseEntity.status(HttpStatus.OK).body(pessoas);
	}

	@Transactional
	@PostMapping
	public ResponseEntity<Void> CadastrarPessoa(@RequestBody PessoaDTO pessoaDto, UriComponentsBuilder uriBuilder) {

		pessoaService.salvarPessoa(pessoaDto);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Transactional
	@PostMapping("/cadastrarPessoas")
	public ResponseEntity<Void> CadastrarPessoas(@RequestBody List<PessoaDTO> pessoaDto) {

		 pessoaService.salvarPessoas(pessoaDto);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPessoa(@PathVariable Long id) {
		Pessoa pessoa = pessoaService.buscarPessoa(id);

		return ResponseEntity.status(HttpStatus.OK).body(pessoa);
	}

}
