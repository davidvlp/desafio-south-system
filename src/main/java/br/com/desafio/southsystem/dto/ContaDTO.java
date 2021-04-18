package br.com.desafio.southsystem.dto;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.desafio.southsystem.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {
	private Long id;
	
	private Integer numConta;
	
	private Integer agencia;
	
	private String tipoConta;
	
	private BigDecimal chequeEspecial;
	
	private BigDecimal cartaoCredito;
	
	
	private Pessoa pessoa;
	
}
