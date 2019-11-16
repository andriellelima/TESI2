package br.ufac.si.academico.controladores;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.academico.entidades.*;
import br.ufac.si.academico.gerentes.*;

@ManagedBean(name="vendaControlador")
@SessionScoped
public class VendaControlador {

	private VendaGerente vg;

	private Venda venda;
	private String chave = "";

	
	public VendaControlador() {
		vg = new VendaGerente();

	}

	public String incluir() {
		this.venda = new Venda();
		return "vendaInclusao";
	}
	
	public String editar(Venda venda) {
		this.venda = venda;
		return "vendaEdicao";
	}

	public String excluir(Venda venda) {
		this.venda = venda;
		return "vendaExclusao";
	}
	
	public String adicionar() {
		vg.adicionar(venda);
		return "vendaGerenciamento";
	}
	
	public String atualizar() {
		vg.atualizar(venda);
		return "vendaGerenciamento";
	}
	
	public String remover() {
		vg.remover(venda);
		return "vendaGerenciamento";
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Venda> getVendas() {
		return vg.recuperarTodosPorNomeContendo(chave);
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}


}
