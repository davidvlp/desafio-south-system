package br.com.desafio.southsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
	
	private Long id;
	private String nome;
	private String tipoPessoa;
	private String numDocumento;
	private Integer score;
	
}
