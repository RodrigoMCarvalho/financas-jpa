package br.com.financiasjpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financiasjpa.modelo.Categoria;
import br.com.financiasjpa.modelo.Movimentacao;
import br.com.financiasjpa.modelo.TipoMovimentacao;
import br.com.financiasjpa.util.JPAUtil;

public class TesteMovimentacaoPorCategoria {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		String jpql = "SELECT m FROM Movimentacao m"
				+ " JOIN m.categoria c"
				+ " WHERE c = :pCategoria";
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
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
