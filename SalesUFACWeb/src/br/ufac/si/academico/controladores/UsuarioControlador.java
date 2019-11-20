package br.ufac.si.academico.controladores;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.academico.entidades.*;
import br.ufac.si.academico.gerentes.*;

@ManagedBean(name="usuarioControlador")
@SessionScoped
public class UsuarioControlador {

	private UsuarioGerente ug;
	private ClienteGerente cg;
	private VendedorGerente vg;

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
	
	public String Login(String email, String senha) throws NoSuchAlgorithmException {
		MessageDigest m=MessageDigest.getInstance("MD5");
		m.update(senha.getBytes(),0,senha.length());
		Usuario us = (Usuario) ug.logar(email, new BigInteger(1,m.digest()).toString(16));
		if(us != null) {
			if(cg.recuperaID(us.getId())!=null) {
				return "Cliente";
			}else {
				if(vg.recuperaID(us.getId())!=null) {
					return "Vendedor";
				}
			}
		}else {
			return "Email ou senha incorretos";
		}
		
		return "Um erro inesperado ocorreu, tente novamente";
		
	}


}
