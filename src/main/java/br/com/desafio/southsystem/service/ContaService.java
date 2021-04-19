package br.com.desafio.southsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.southsystem.dto.ContaDTO;
import br.com.desafio.southsystem.dto.ParseDTO;
import br.com.desafio.southsystem.exception.ExceptionMessages;
import br.com.desafio.southsystem.exception.SoutSystemNotFoundException;
import br.com.desafio.southsystem.model.Conta;
import br.com.desafio.southsystem.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;

	public List<ContaDTO> listarContas() {

		List<Conta> contas = contaRepository.findAll();
		return contas.stream().map(ParseDTO::contaToContaDto).collect(Collectors.toList());

	}

	public ContaDTO buscarContaPorID(Long id) {

		return ParseDTO.contaToContaDto(contaRepository.findById(id).orElseThrow(
				() -> new SoutSystemNotFoundException(ExceptionMessages.getContaNotFoundExceptionMessage(id))));

	}

	public Conta salvarConta(Conta conta) {
		Conta contaSalva = new Conta();
		try {
			contaSalva = contaRepository.save(conta);
			return contaSalva;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return contaSalva;

	}

}
