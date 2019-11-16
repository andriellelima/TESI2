package br.ufac.si.academico.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.academico.entidades.Cliente;
import br.ufac.si.academico.entidades.Produto;
import br.ufac.si.academico.entidades.Vendedor;

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
	
	public Produto recuperar(long l) {
		return em.find(Produto.class, l);
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
	
	public void avali(Produto pr, double nota) {
//		Vendedor v = new Vendedor(nome, cpf, dataNascimento, senha)
		pr.setAvaliacao(((pr.getAvaliacao()*pr.getQuantaval())+nota)/(pr.getQuantaval()+1));
		atualizar(pr);
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> recuperarTodos(){
		return em.createNamedQuery("Produto.todos")
				.getResultList();	
	}
	@SuppressWarnings("unchecked")
	public List<Produto> recuperarTodosPorNome(){
		return em.createNamedQuery("Produto.todosPorNome")
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Produto> recuperarTodosPorNomeContendo(String termo){
		return em
				.createNamedQuery("Produto.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
	}	
	
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
