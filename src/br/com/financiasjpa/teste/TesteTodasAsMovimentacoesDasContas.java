package br.com.financiasjpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financiasjpa.modelo.Conta;
import br.com.financiasjpa.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		//String jpql = "SELECT c FROM Conta c";
		String jpql = "SELECT DISTINCT c FROM Conta c LEFT JOIN FETCH c.movimentacoes"; //para evitar lazy(varias buscas no BD)
		
		Query query = em.createQuery(jpql);
		
		List<Conta> contas = query.getResultList();
		
		for (Conta conta : contas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentaçoes:");
			System.out.println("Titular: " + conta.getMovimentacoes());
		}
		
		
		
		
		
		
		
	}
}
