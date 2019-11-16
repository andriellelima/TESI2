package br.ufac.si.academico.controladores;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.academico.entidades.*;
import br.ufac.si.academico.gerentes.*;

@ManagedBean(name="produtoControlador")
@SessionScoped
public class ProdutoControlador {

	private ProdutoGerente pg;

	private Produto produto;
	private String chave = "";

	
	public ProdutoControlador() {
		pg = new ProdutoGerente();

	}

	public String incluir() {
		this.produto = new Produto();
		return "produtoInclusao";
	}
	
	public String editar(Produto produto) {
		this.produto = produto;
		return "produtoEdicao";
	}

	public String excluir(Produto produto) {
		this.produto = produto;
		return "produtoExclusao";
	}
	
	public String adicionar() {
		pg.adicionar(produto);
		return "produtoGerenciamento";
	}
	
	public String atualizar() {
		pg.atualizar(produto);
		return "produtoGerenciamento";
	}
	
	public String remover() {
		pg.remover(produto);
		return "produtoGerenciamento";
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return pg.recuperarTodosPorNomeContendo(chave);
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}


}
