package br.com.desafio.southsystem.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONTA")
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NUMCONTA")
	private Integer numConta;
	
	@Column(name = "AGENCIA")
	private Integer agencia;
	
	@Column(name = "TIPOCONTA")
	private String tipoConta;
	
	@Column(name = "CHEQUEESPECIAL")
	private BigDecimal chequeEspecial;
	
	@Column(name = "CARTAOCREDITO")
	private BigDecimal cartaoCredito;
	
	
}
