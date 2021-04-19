package br.com.desafio.southsystem.model;

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
@Table(name = "PESSOA")
public class Pessoa {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "TIPOPESSOA")
	private String tipoPessoa;
	
	@Column(name = "NUMDOCUMENTO")
	private String numDocumento;
	
	@Column(name = "SCORE")
	private Integer score;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
	private Conta conta;
	
}
