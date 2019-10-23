package br.ufac.si.academico.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.academico.entidades.Produto;

public class ProdutoGerente {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ProdutoGerente() {
		emf = Persistence.createEntityManagerFactory("SalesUFAC");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Produto produto) {
//		ProdutoGerente us = new ProdutoGerente();
		
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}
	
	public Produto recuperar(int id) {
		return em.find(Produto.class, id);
	}
	
	public void atualizar(Produto produto) {
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
	}
	
	public void remover(Produto produto) {
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
	}
	
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
