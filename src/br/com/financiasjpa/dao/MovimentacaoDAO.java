package br.com.financiasjpa.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.financiasjpa.modelo.Conta;
import br.com.financiasjpa.modelo.TipoMovimentacao;

public class MovimentacaoDAO {

	private EntityManager em;

	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}

	public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {
		String jpql = "SELECT AVG(m.valor) FROM Movimentacao m " + 
				" WHERE m.conta = :pConta" + " AND m.tipo = :pTipo" + 
				" GROUP BY DAY(m.data), MONTH(m.data), YEAR(m.data)";

		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", saida);

		return query.getResultList();
	}

	public BigDecimal getSoma(TipoMovimentacao saida, Conta conta) {
		String jpql = "SELECT SUM(m.valor) FROM Movimentacao m " + 
				" WHERE m.conta = :pConta" + 
				" AND m.tipo = :pTipo";

		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", saida);

		BigDecimal soma = (BigDecimal) query.getSingleResult();
		
		return soma;
	}
}
