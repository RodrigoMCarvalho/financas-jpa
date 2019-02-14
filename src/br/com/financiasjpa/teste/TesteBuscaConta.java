package br.com.financiasjpa.teste;

import javax.persistence.EntityManager;

import br.com.financiasjpa.modelo.Conta;
import br.com.financiasjpa.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		conta.setBanco("009 - BANCO DE NY");
		
		System.out.println(conta.getBanco());
		
		em.getTransaction().commit();
		em.close();
	}
}
