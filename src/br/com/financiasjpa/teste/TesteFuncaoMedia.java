package br.com.financiasjpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.financiasjpa.modelo.Conta;
import br.com.financiasjpa.modelo.TipoMovimentacao;
import br.com.financiasjpa.util.JPAUtil;

public class TesteFuncaoMedia {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 11);

		String jpql = "SELECT AVG(m.valor) FROM Movimentacao m " + 
				" WHERE m.conta = :pConta" + 
				" AND m.tipo = :pTipo" +
				" GROUP BY DAY(m.data), MONTH(m.data), YEAR(m.data)";

		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		List<Double> media = (List<Double>) query.getResultList();
		System.out.println("A Media é " + media);
	}

}
