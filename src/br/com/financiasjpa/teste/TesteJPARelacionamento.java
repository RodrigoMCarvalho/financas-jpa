package br.com.financiasjpa.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.financiasjpa.modelo.Conta;
import br.com.financiasjpa.modelo.Movimentacao;
import br.com.financiasjpa.modelo.TipoMovimentacao;
import br.com.financiasjpa.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setBanco("001 - BANCO DO BRASIL");
		conta.setNumero("16987-8");
		conta.setAgencia("6543");
		conta.setTitular("Gustavo");
		
		Movimentacao movimentacao = new Movimentacao(); 
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Churrascaria - JANEIRO/2018");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200.0"));
		movimentacao.setConta(conta);
		
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		
		em.close();
		

	}

}
