package br.ufac.si.academico.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.academico.entidades.Cliente;
import br.ufac.si.academico.entidades.Venda;

public class VendaGerente {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public VendaGerente() {
		emf = Persistence.createEntityManagerFactory("SalesUFAC");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Venda venda) {
		
		em.getTransaction().begin();
		em.persist(venda);
		em.getTransaction().commit();
	}
	
	public Venda recuperar(int id) {
		return em.find(Venda.class, id);
	}
	
	public void atualizar(Venda venda) {
		em.getTransaction().begin();
		em.merge(venda);
		em.getTransaction().commit();
	}
	
	public void remover(Venda venda) {
		em.getTransaction().begin();
		em.remove(venda);
		em.getTransaction().commit();
	}
	
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	

	@SuppressWarnings("unchecked")
	public List<Venda> recuperarTodos(){
		return em.createNamedQuery("Venda.todos")
				.getResultList();	
	}
	@SuppressWarnings("unchecked")
	public List<Venda> recuperarTodosPorNome(){
		return em.createNamedQuery("Venda.todosPorNome")
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Venda> recuperarTodosPorNomeContendo(String termo){
		return em
				.createNamedQuery("Venda.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
	}	
	
}
