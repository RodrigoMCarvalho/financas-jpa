package br.com.financiasjpa.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.financiasjpa.dao.MovimentacaoDAO;
import br.com.financiasjpa.modelo.Conta;
import br.com.financiasjpa.modelo.TipoMovimentacao;
import br.com.financiasjpa.util.JPAUtil;

public class TesteFuncaoMedia {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta = em.find(Conta.class, 11);
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		List<Double> media = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);
		
		System.out.println("A Media é " + media);
		
		em.getTransaction().commit();
		em.close();
	}

}
