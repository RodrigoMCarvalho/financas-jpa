package br.com.financiasjpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financiasjpa.modelo.Conta;
import br.com.financiasjpa.modelo.Movimentacao;
import br.com.financiasjpa.modelo.TipoMovimentacao;
import br.com.financiasjpa.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(3);
		
		String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :pConta" +
		" AND m.tipo = :pTipo" +
		" ORDER BY m.valor DESC";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> resultado = query.getResultList();
		for (Movimentacao movimentacao : resultado) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Conta ID: " + movimentacao.getConta().getId());
			System.out.println("Valor: " + movimentacao.getValor());
		}
		
		em.getTransaction().commit();
		em.close();
		
		
		
		
		
		
	}

}
