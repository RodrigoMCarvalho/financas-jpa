package br.com.financiasjpa.teste;

import javax.persistence.EntityManager;

import br.com.financiasjpa.modelo.Cliente;
import br.com.financiasjpa.modelo.Conta;
import br.com.financiasjpa.util.JPAUtil;

public class TesteContaCliente {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 2);
		//Cliente cliente = new Cliente("Ailton", "Rua A", "Inspetor", conta);
		Cliente cliente2 = new Cliente("Mario", "Rua 21", "Bombeiro", conta);
		
		//em.persist(cliente);
		em.persist(cliente2);
		em.getTransaction().commit();
		
		em.close();

	}

}
