package br.com.financiasjpa.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.financiasjpa.modelo.Categoria;
import br.com.financiasjpa.modelo.Conta;
import br.com.financiasjpa.modelo.Movimentacao;
import br.com.financiasjpa.modelo.TipoMovimentacao;

public class PopulaMovimentacaoComCategoria {

	public static void main(String[] args) {

		
		Categoria cat1 = new Categoria("viagem");
		Categoria cat2 = new Categoria("negocio");
		
		Conta conta = new Conta();
		conta.setId(11);
		
		Movimentacao mov1 = new Movimentacao();
		mov1.setData(Calendar.getInstance());
		mov1.setDescricao("viagem ao Jap�o");
		mov1.setTipo(TipoMovimentacao.SAIDA);
		mov1.setCategoria(Arrays.asList(cat1, cat2));
		mov1.setValor(new BigDecimal("1800.0"));
		mov1.setConta(conta);
		
		Movimentacao mov2 = new Movimentacao();
		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		
		
		mov2.setData(amanha);
		mov2.setDescricao("viagem a Fran�a");
		mov2.setTipo(TipoMovimentacao.SAIDA);
		mov2.setCategoria(Arrays.asList(cat1, cat2));
		mov2.setValor(new BigDecimal("2500.0"));
		mov2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cat1);
		em.persist(cat2);
		
		em.persist(mov1);
		em.persist(mov2);
		em.getTransaction().commit();
		
		em.close();
		
	}
}
