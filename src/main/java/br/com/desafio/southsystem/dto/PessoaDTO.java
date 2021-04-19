package br.com.desafio.southsystem.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class PessoaDTO {
	
	private Long id;
	
	@NotNull(message = "Nome cannot be null")
	@NotEmpty(message = "Nome cannot be empty")
	private String nome;
	
	@NotNull(message = "TipoPessoa cannot be null")
	@NotEmpty(message = "TipoPessoa cannot be empty")
	private String tipoPessoa;
	
	@NotNull(message = "NumDocumento cannot be null")
	@NotEmpty(message = "NumDocumento cannot be empty")
	private String numDocumento;
	
	private Integer score;
	
	private ContaDTO contaDto;
}
