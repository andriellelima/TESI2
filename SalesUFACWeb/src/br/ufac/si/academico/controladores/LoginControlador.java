package br.ufac.si.academico.controladores;

import java.security.NoSuchAlgorithmException;
import java.util.*;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

//import br.ufac.si.academico.MB.Usuario;
//import br.ufac.si.academico.MB.UsuarioGerente;

import br.ufac.si.academico.entidades.*;
import br.ufac.si.academico.gerentes.*;

@ManagedBean(name="loginControlador")
@SessionScoped
public class LoginControlador {

	private UsuarioGerente ug;
	private Usuario usuarioLogado;
	private String senha;
	private String login;
	
	public LoginControlador() {
		ug = new UsuarioGerente();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Usuario getUsuariologado() {
		return usuarioLogado;
	}
	
	public String entrar() throws NoSuchAlgorithmException {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		usuarioLogado = ug.recuperar(login, senha);
		
		
		
//		usuarioLogado = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		
		if(usuarioLogado != null) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", usuarioLogado);
			return "index.xhtml?faces-redirect=true";
		}else {
//			return "login.xhtml?faces-redirect=true";
			return null;
		}
		
	}
	
	public String sair() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		return "login.xhtml?faces-redirect=true";

	}
	
}
