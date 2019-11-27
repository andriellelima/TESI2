package br.ufac.si.academico.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.academico.entidades.Cliente;
import br.ufac.si.academico.entidades.Vendedor;

public class VendedorGerente {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public VendedorGerente() {
		emf = Persistence.createEntityManagerFactory("SalesUFAC");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Vendedor vendedor) {
//		VendedorGerente us = new VendedorGerente();
		
		em.getTransaction().begin();
		em.persist(vendedor);
		em.getTransaction().commit();
	}
	
	public Vendedor recuperar(int id) {
		return em.find(Vendedor.class, id);
	}

	
	public void atualizar(Vendedor vendedor) {
		em.getTransaction().begin();
		em.merge(vendedor);
		em.getTransaction().commit();
	}
	
	public void remover(Vendedor vendedor) {
		em.getTransaction().begin();
		em.remove(vendedor);
		em.getTransaction().commit();
	}
	
	public void avali(Vendedor ven, double nota) {
//		Vendedor v = new Vendedor(nome, cpf, dataNascimento, senha)
		ven.setAvaliacao(((ven.getAvaliacao()*ven.getQuantaval())+nota)/(ven.getQuantaval()+1));
		atualizar(ven);
	}
	
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Vendedor> recuperarTodos(){
		return em.createNamedQuery("Vendedor.todos")
				.getResultList();	
	}
	@SuppressWarnings("unchecked")
	public List<Vendedor> recuperarTodosPorNome(){
		return em.createNamedQuery("Vendedor.todosPorNome")
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Vendedor> recuperarTodosPorNomeContendo(String termo){
		return em
				.createNamedQuery("Vendedor.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
	}	
	@SuppressWarnings("unchecked")
	public Vendedor recuperaID(long termo) {
		return (Vendedor) em.createNamedQuery("Vendedor.porid").setParameter("termo", termo).getSingleResult();
	}
	
}
