package br.ufac.si.academico.gerentes;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.logging.Logger;

import javax.persistence.*;

import br.ufac.si.academico.entidades.Cliente;
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
	
	@SuppressWarnings("unchecked")
	public List<Usuario> recuperarTodos(){
		return em.createNamedQuery("Usuario.todos")
				.getResultList();	
	}
	@SuppressWarnings("unchecked")
	public List<Usuario> recuperarTodosPorNome(){
		return em.createNamedQuery("Usuario.todosPorNome")
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Usuario> recuperarTodosPorNomeContendo(String termo){
		return em
				.createNamedQuery("Usuario.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
	}	
	@SuppressWarnings("unchecked")
	public List<Usuario> poremail(String termo){
		return em
				.createNamedQuery("Usuario.poremail")
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
	}	
	
	public Usuario recuperaruser(String email, String senha) {
		return (Usuario) em.createNamedQuery("Usuario.login").setParameter("email", email)
				.setParameter("senha",  senha).getSingleResult();
	}
//	public void logar() {
//		email = email.toLowerCase().trim();
//		List <Usuario> user = em.createNamedQuery("Usuario.login").setParameter("email", )
//				.setParameter("senha", senha).getResultList();
//		if(user.size()==1) {
//			
//		}
//	}
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
//	public UsuarioGerente() {
//		usuarios.add(new Usuario("lulinhasemdedo", "lulinha", "123456789"));
//		usuarios.add(new Usuario("dirma", "dilminha", "123456789"));
//		usuarios.add(new Usuario("bolso", "bolsonaro", "123456789"));
//		
//	}

	public Usuario recuperar(String login, String senha) throws NoSuchAlgorithmException {
		MessageDigest m=MessageDigest.getInstance("MD5");
		m.update(senha.getBytes(),0,senha.length());
		String Senha = new BigInteger(1,m.digest()).toString(16);
		usuarios = recuperarTodos();
		for(Usuario usuario : usuarios) {
			if(usuario.getEmail().equals(login) && usuario.getSenha().equals(Senha)) {
				return usuario;
			}
		}
			
		return null;
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
	

}
