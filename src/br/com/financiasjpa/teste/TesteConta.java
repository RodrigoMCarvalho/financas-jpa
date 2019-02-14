package br.com.financiasjpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.financiasjpa.modelo.Conta;
import br.com.financiasjpa.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		Conta conta = new Conta();
		
		conta.setTitular("Rodrigo");
		conta.setAgencia("123");
		conta.setNumero("123456");
		conta.setBanco("Caixa");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
