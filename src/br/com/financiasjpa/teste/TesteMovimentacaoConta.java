package br.com.financiasjpa.teste;

import javax.persistence.EntityManager;

import br.com.financiasjpa.modelo.Conta;
import br.com.financiasjpa.modelo.Movimentacao;
import br.com.financiasjpa.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 5);
		Conta conta = movimentacao.getConta();
		
		System.out.println(conta.getTitular());
		System.out.println(conta.getMovimentacoes().size());

	}

}
