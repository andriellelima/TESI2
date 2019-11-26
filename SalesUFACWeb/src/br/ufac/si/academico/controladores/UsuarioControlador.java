package br.ufac.si.academico.controladores;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.logging.*;

import javax.faces.bean.*;
import javax.servlet.*;

import com.mysql.fabric.Response;

import br.ufac.si.academico.entidades.*;
import br.ufac.si.academico.gerentes.*;

@ManagedBean(name="usuarioControlador" , eager = true)
@SessionScoped
public class UsuarioControlador implements Serializable{

	private UsuarioGerente ug;
	private ClienteGerente cg;
	private VendedorGerente vg;

	private Usuario usuario;
	private String chave = "";
	private static final Logger LOG = Logger.getLogger(Usuario.class.getName());

	
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
	
	@Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.getUsuario().getEmail());
        return hash;
    }
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.getUsuario().getEmail(), other.login)) {
            return false;
        }
        return true;
    }
	
	@Override
    public String toString() {
        return this.getUsuario().getNome();
    }
	
//	public Usuario userlog() {
//		MessageDigest m;
//		try {
//			m = MessageDigest.getInstance("MD5");
//			m.update(usuario.getSenha().getBytes(),0,usuario.getSenha().length());
//			
//			Usuario uss = ug.recuperaruser(usuario.getEmail().trim().toLowerCase(), new BigInteger(1,m.digest()).toString(16));
//			
//			if(uss != null) {
////				if(cg.recuperaID(uss.getId())!=null) {
////					
////					return "Cliente";
////				}else {
////					if(vg.recuperaID(uss.getId())!=null) {
////						return "Vendedor";
////					}
////				}
//			}
//			
//			
//			return uss;
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//		
//	}
	
//	public String Login(String email, String senha) throws NoSuchAlgorithmException {
//		MessageDigest m=MessageDigest.getInstance("MD5");
//		m.update(senha.getBytes(),0,senha.length());
//		Usuario us = (Usuario) ug.recuperaruser(email, new BigInteger(1,m.digest()).toString(16));
//		if(us != null) {
//			if(cg.recuperaID(us.getId())!=null) {
//				return "Cliente";
//			}else {
//				if(vg.recuperaID(us.getId())!=null) {
//					return "Vendedor";
//				}
//			}
//		}else {
//			return "Email ou senha incorretos";
//		}
//		
//		return "Um erro inesperado ocorreu, tente novamente";
//		
//	}


}
