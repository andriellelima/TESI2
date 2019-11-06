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
	
}
