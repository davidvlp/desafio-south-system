package br.com.desafio.southsystem.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.desafio.southsystem.model.Conta;
import br.com.desafio.southsystem.model.Pessoa;

public class ParseDTO {
	
	    
	    public static PessoaDTO pessoaToPessoaDto(Pessoa pessoa) {
	        if ( pessoa == null ) {
	            return null;
	        }

	        PessoaDTO pessoaDTO = new PessoaDTO();

	        pessoaDTO.setId( pessoa.getId() );
	        pessoaDTO.setNome( pessoa.getNome() );
	        pessoaDTO.setTipoPessoa( pessoa.getTipoPessoa() );
	        pessoaDTO.setNumDocumento( pessoa.getNumDocumento() );
	        pessoaDTO.setScore( pessoa.getScore() );
	        pessoaDTO.setContaDto(contaToContaDto(pessoa.getConta()));

	        return pessoaDTO;
	    }

	    public static Pessoa pessoaDtoToPessoa(PessoaDTO pessoaDto) {
	        if ( pessoaDto == null ) {
	            return null;
	        }

	        Pessoa pessoa = new Pessoa();

	        pessoa.setId( pessoaDto.getId() );
	        pessoa.setNome( pessoaDto.getNome() );
	        pessoa.setTipoPessoa( pessoaDto.getTipoPessoa() );
	        pessoa.setNumDocumento( pessoaDto.getNumDocumento() );
	        pessoa.setScore( pessoaDto.getScore() );
	        pessoa.setConta(contaDtoToConta(pessoaDto.getContaDto()));

	        return pessoa;
	    }

	    public List<PessoaDTO> map(List<Pessoa> employees) {
	        if ( employees == null ) {
	            return null;
	        }

	        List<PessoaDTO> list = new ArrayList<PessoaDTO>( employees.size() );
	        for ( Pessoa pessoa : employees ) {
	            list.add( pessoaToPessoaDto( pessoa ) );
	        }

	        return list;
	    }
	    
	    

	    public static ContaDTO contaToContaDto(Conta beer) {
	        if ( beer == null ) {
	            return null;
	        }

	        ContaDTO contaDTO = new ContaDTO();

	        contaDTO.setId( beer.getId() );
	        contaDTO.setNumConta( beer.getNumConta() );
	        contaDTO.setAgencia( beer.getAgencia() );
	        contaDTO.setTipoConta( beer.getTipoConta() );
	        contaDTO.setChequeEspecial( beer.getChequeEspecial() );
	        contaDTO.setCartaoCredito( beer.getCartaoCredito() );

	        return contaDTO;
	    }

	    public static Conta contaDtoToConta(ContaDTO beerDto) {
	        if ( beerDto == null ) {
	            return null;
	        }

	        Conta conta = new Conta();

	        conta.setId( beerDto.getId() );
	        conta.setNumConta( beerDto.getNumConta() );
	        conta.setAgencia( beerDto.getAgencia() );
	        conta.setTipoConta( beerDto.getTipoConta() );
	        conta.setChequeEspecial( beerDto.getChequeEspecial() );
	        conta.setCartaoCredito( beerDto.getCartaoCredito() );

	        return conta;
	    }
}
