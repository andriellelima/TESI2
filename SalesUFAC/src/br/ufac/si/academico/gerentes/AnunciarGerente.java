package br.ufac.si.academico.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.academico.entidades.Anunciar;
import br.ufac.si.academico.entidades.Cliente;

public class AnunciarGerente {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public AnunciarGerente() {
		emf = Persistence.createEntityManagerFactory("SalesUFAC");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Anunciar anunciar) {
		
		em.getTransaction().begin();
		em.persist(anunciar);
		em.getTransaction().commit();
	}
	
	public Anunciar recuperar(int id) {
		return em.find(Anunciar.class, id);
	}
	
	public void atualizar(Anunciar anunciar) {
		em.getTransaction().begin();
		em.merge(anunciar);
		em.getTransaction().commit();
	}
	
	public void remover(Anunciar anunciar) {
		em.getTransaction().begin();
		em.remove(anunciar);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Anunciar> recuperarTodos(){
		return em.createNamedQuery("Anunciar.todos")
				.getResultList();	
	}
	@SuppressWarnings("unchecked")
	public List<Anunciar> recuperarTodosPorNome(){
		return em.createNamedQuery("Anunciar.todosPorNome")
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Anunciar> recuperarTodosPorNomeContendo(String termo){
		return em
				.createNamedQuery("Anunciar.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
	}	
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
