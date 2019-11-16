package br.ufac.si.academico.controladores;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.academico.entidades.*;
import br.ufac.si.academico.gerentes.*;

@ManagedBean(name="clienteControlador")
@SessionScoped
public class ClienteControlador {

	private ClienteGerente cg;

	private Cliente cliente;
	private String chave = "";

	
	public ClienteControlador() {
		cg = new ClienteGerente();

	}

	public String incluir() {
		this.cliente = new Cliente();
		return "clienteInclusao";
	}
	
	public String editar(Cliente cliente) {
		this.cliente = cliente;
		return "clienteEdicao";
	}

	public String excluir(Cliente cliente) {
		this.cliente = cliente;
		return "clienteExclusao";
	}
	
	public String adicionar() {
		cg.adicionar(cliente);
		return "clienteGerenciamento";
	}
	
	public String atualizar() {
		cg.atualizar(cliente);
		return "clienteGerenciamento";
	}
	
	public String remover() {
		cg.remover(cliente);
		return "clienteGerenciamento";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return cg.recuperarTodosPorNomeContendo(chave);
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}


}
