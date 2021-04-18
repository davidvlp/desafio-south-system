package br.com.desafio.southsystem.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.southsystem.dto.ContaDTO;
import br.com.desafio.southsystem.dto.ParseDTO;
import br.com.desafio.southsystem.dto.PessoaDTO;
import br.com.desafio.southsystem.model.Conta;
import br.com.desafio.southsystem.model.Pessoa;
import br.com.desafio.southsystem.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	ContaService contaService;
	
	
	
	public List<Pessoa> listarPessoa () {
		
		return pessoaRepository.findAll();
		
	}
	
public Optional<Pessoa> buscarPessoa (Long id) {
		
		return pessoaRepository.findById(id);
		
	}
	public PessoaDTO salvarPessoa (PessoaDTO pessoaDto) {
		
		Pessoa pessoa = ParseDTO.pessoaDtoToPessoa(pessoaDto);
		Random random = new Random();
		Integer score = random.nextInt(9);
		pessoa.setScore(score);
		
		pessoa = pessoaRepository.save(pessoa);
		
		Conta conta = montarDadosConta(pessoa, random);
												
		ContaDTO contaDto = contaService.salvarConta(conta);
		
		return ParseDTO.pessoaToPessoaDto(pessoa);
		
	}

	
	public List<PessoaDTO> salvarPessoas (List<PessoaDTO> pessoaDto) {

	List<PessoaDTO> listaPessoas = new ArrayList<PessoaDTO>();
		
		for (PessoaDTO pessoaDTO2 : pessoaDto) {
			
			Pessoa pessoa = ParseDTO.pessoaDtoToPessoa(pessoaDTO2);
			Random random = new Random();
			Integer score = random.nextInt(9);
			pessoa.setScore(score);
			
			pessoa = pessoaRepository.save(pessoa);
			
			Conta conta = montarDadosConta(pessoa, random);
			
			ContaDTO contaDto = contaService.salvarConta(conta);
			listaPessoas.add(ParseDTO.pessoaToPessoaDto(pessoa));
		}
		
		  
		return listaPessoas;
	}

	private Conta montarDadosConta(Pessoa pessoa, Random random) {
		Conta conta = new Conta();
		
		int i =  (100000 + random.nextInt(899999));
		conta.setNumConta(i);
		conta.setAgencia(4056);
		conta.setTipoConta(pessoa.getTipoPessoa().equals("pf") ? "C" : "E");
		conta.setPessoa(pessoa);
		
		if (pessoa.getScore() >= 2 && pessoa.getScore()<= 5 ) {
			conta.setChequeEspecial(BigDecimal.valueOf(1000.00));
			conta.setCartaoCredito(BigDecimal.valueOf(200.00));
			
		}else if (pessoa.getScore() >= 6 && pessoa.getScore()<= 8) {
			conta.setChequeEspecial(BigDecimal.valueOf(2000.00));
			conta.setCartaoCredito(BigDecimal.valueOf(2000.00));
			
		}else if (pessoa.getScore().equals(9)) {
			conta.setChequeEspecial(BigDecimal.valueOf(5000.00));
			conta.setCartaoCredito(BigDecimal.valueOf(15000.00));
			
		}
		
		return conta;
	} 
}
