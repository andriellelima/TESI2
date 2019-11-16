package br.ufac.si.academico.controladores;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.academico.entidades.*;
import br.ufac.si.academico.gerentes.*;

@ManagedBean(name="vendedorControlador")
@SessionScoped
public class VendedorControlador {

	private VendedorGerente vg;

	private Vendedor vendedor;
	private String chave = "";

	
	public VendedorControlador() {
		vg = new VendedorGerente();

	}

	public String incluir() {
		this.vendedor = new Vendedor();
		return "vendedorInclusao";
	}
	
	public String editar(Vendedor vendedor) {
		this.vendedor = vendedor;
		return "vendedorEdicao";
	}

	public String excluir(Vendedor vendedor) {
		this.vendedor = vendedor;
		return "vendedorExclusao";
	}
	
	public String adicionar() {
		vg.adicionar(vendedor);
		return "vendedorGerenciamento";
	}
	
	public String atualizar() {
		vg.atualizar(vendedor);
		return "vendedorGerenciamento";
	}
	
	public String remover() {
		vg.remover(vendedor);
		return "vendedorGerenciamento";
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public List<Vendedor> getVendedors() {
		return vg.recuperarTodosPorNomeContendo(chave);
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}


}
