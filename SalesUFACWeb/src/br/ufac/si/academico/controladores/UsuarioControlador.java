package br.ufac.si.academico.controladores;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.academico.entidades.*;
import br.ufac.si.academico.gerentes.*;

@ManagedBean(name="usuarioControlador")
@SessionScoped
public class UsuarioControlador {

	private UsuarioGerente ug;

	private Usuario usuario;
	private String chave = "";

	
	public UsuarioControlador() {
		ug = new UsuarioGerente();

	}

	public String incluir() {
		this.usuario = new Usuario();
		return "usuarioInclusao";
	}
	
	public String editar(Usuario usuario) {
		this.usuario = usuario;
		return "usuarioEdicao";
	}

	public String excluir(Usuario usuario) {
		this.usuario = usuario;
		return "usuarioExclusao";
	}
	
	public String adicionar() {
		ug.adicionar(usuario);
		return "usuarioGerenciamento";
	}
	
	public String atualizar() {
		ug.atualizar(usuario);
		return "usuarioGerenciamento";
	}
	
	public String remover() {
		ug.remover(usuario);
		return "usuarioGerenciamento";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return ug.recuperarTodosPorNomeContendo(chave);
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}


}
