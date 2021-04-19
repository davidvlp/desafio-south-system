package br.com.desafio.southsystem.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ContaDTO {
	
	
	private Long id;
	
	private Integer numConta;
	
	private Integer agencia;
	
	private String tipoConta;
	
	private BigDecimal chequeEspecial;
	
	private BigDecimal cartaoCredito;
	
	
	
}
