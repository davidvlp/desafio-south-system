package br.com.desafio.southsystem.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.desafio.southsystem.model.Conta;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContaRepositoryTest {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Test
	public void salvarContaTest() {
		Conta conta = contaRepository.save(getConta());
		assertTrue(contaRepository.findById(conta.getId()).isPresent());
		System.out.println("Se liga: " + contaRepository.findById(conta.getId()).get().getId());
		assertEquals(conta.getAgencia(), contaRepository.findById(conta.getId()).get().getAgencia());
	}
	
	@Test
	public void buscarContaTest() {
		List<Conta> findAll = contaRepository.findAll();
	    assertFalse(findAll.isEmpty());
	}
	
	@Test
	public void buscarContaPeloIdtest() {
		Optional<Conta> beer = contaRepository.findById(1L);
		assertTrue(beer.isPresent());
	}
	
	
	
	private Conta getConta() {
		Conta b = new Conta();
		b.setNumConta(23232);
		b.setAgencia(4566);
		b.setTipoConta("C");
		b.setChequeEspecial(new BigDecimal(9d));
		b.setChequeEspecial(new BigDecimal(9d));
		return b;
	}
	
}
