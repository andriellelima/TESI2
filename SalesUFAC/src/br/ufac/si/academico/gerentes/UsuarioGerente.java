package br.ufac.si.academico.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.academico.entidades.Usuario;

public class UsuarioGerente {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public UsuarioGerente() {
		emf = Persistence.createEntityManagerFactory("SalesUFAC");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Usuario usuario) {
//		UsuarioGerente us = new UsuarioGerente();
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}
	
	public Usuario recuperar(int id) {
		return em.find(Usuario.class, id);
	}
	
	public void atualizar(Usuario usuario) {
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	}
	
	public void remover(Usuario usuario) {
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
	}
	
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
