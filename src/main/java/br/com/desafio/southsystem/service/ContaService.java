package br.com.desafio.southsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.southsystem.dto.ContaDTO;
import br.com.desafio.southsystem.dto.ParseDTO;
import br.com.desafio.southsystem.model.Conta;
import br.com.desafio.southsystem.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;
	
	
	 
	
	
	
	public List<Conta> listarContas () {
		
		return contaRepository.findAll();
		
	}
	
public Optional<Conta> buscarContaPorID (Long id) {
		
		return contaRepository.findById(id);
		
	}
	public ContaDTO salvarConta (Conta conta) {
		
		Conta contaSalva = contaRepository.save(conta);
	
		
		ContaDTO contaDto =ParseDTO.contaToContaDto(contaSalva);
		return contaDto;
		
		
	
		
	}

	
}
