package br.ufac.si.academico.MB;

import java.util.*;

public class UsuarioGerente {
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioGerente() {
		usuarios.add(new Usuario("lulinhasemdedo", "lulinha", "123456789"));
		usuarios.add(new Usuario("dirma", "dilminha", "123456789"));
		usuarios.add(new Usuario("bolso", "bolsonaro", "123456789"));
		
	}

	public Usuario recuperar(String login, String senha) {
		for(Usuario usuario : usuarios) {
			if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
			
		return null;
	}
}
