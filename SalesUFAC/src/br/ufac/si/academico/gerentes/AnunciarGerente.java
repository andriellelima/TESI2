package br.ufac.si.academico.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.academico.entidades.Anunciar;

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
	
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
