package br.ufac.si.academico.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.academico.entidades.Cliente;
import br.ufac.si.academico.entidades.Vendedor;

public class ClienteGerente {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ClienteGerente() {
		emf = Persistence.createEntityManagerFactory("SalesUFAC");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Cliente cliente) {
//		ClienteGerente us = new ClienteGerente();
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	}
	
	public Cliente recuperar(int id) {
		return em.find(Cliente.class, id);
	}
	
	public void atualizar(Cliente cliente) {
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
	}
	
	public void remover(Cliente cliente) {
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
	}

	
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> recuperarTodos(){
		return em.createNamedQuery("Cliente.todos")
				.getResultList();	
	}
	@SuppressWarnings("unchecked")
	public List<Cliente> recuperarTodosPorNome(){
		return em.createNamedQuery("Cliente.todosPorNome")
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Cliente> recuperarTodosPorNomeContendo(String termo){
		return em
				.createNamedQuery("Cliente.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
	}	
	
	@SuppressWarnings("unchecked")
	public List<Cliente> recuperaID(long termo) {
		return em.createNamedQuery("Cliente.porid")
				.setParameter("termo", termo)
				.getResultList();
	}
	
}
