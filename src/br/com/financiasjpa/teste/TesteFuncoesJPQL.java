package br.com.financiasjpa.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financiasjpa.modelo.Conta;
import br.com.financiasjpa.modelo.TipoMovimentacao;
import br.com.financiasjpa.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		
		String jpql = "SELECT SUM(m.valor) FROM Movimentacao m " +
		" WHERE m.conta = :pConta" +
		" AND m.tipo = :pTipo";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		BigDecimal soma = (BigDecimal) query.getSingleResult();
		System.out.println("A soma dos valos da conta do " + conta.getTitular() + " é R$" + soma);
		
		
	}

}
