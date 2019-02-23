package br.com.financiasjpa.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.financiasjpa.dao.MovimentacaoDAO;
import br.com.financiasjpa.modelo.Conta;
import br.com.financiasjpa.modelo.TipoMovimentacao;
import br.com.financiasjpa.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		BigDecimal soma = dao.getSoma(TipoMovimentacao.SAIDA, conta);
		
		System.out.println("A soma dos valos da conta do " + conta.getTitular() + " é R$" + soma);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
