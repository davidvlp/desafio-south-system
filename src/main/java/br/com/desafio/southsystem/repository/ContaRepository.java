package br.com.desafio.southsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.southsystem.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
