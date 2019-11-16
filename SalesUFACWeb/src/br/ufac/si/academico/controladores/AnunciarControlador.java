package br.ufac.si.academico.controladores;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.academico.entidades.*;
import br.ufac.si.academico.gerentes.*;

@ManagedBean(name="anunciarControlador")
@SessionScoped
public class AnunciarControlador {

	private AnunciarGerente ag;

	private Anunciar anunciar;
	private String chave = "";

	
	public AnunciarControlador() {
		ag = new AnunciarGerente();

	}

	public String incluir() {
		this.anunciar = new Anunciar();
		return "anunciarInclusao";
	}
	
	public String editar(Anunciar anunciar) {
		this.anunciar = anunciar;
		return "anunciarEdicao";
	}

	public String excluir(Anunciar anunciar) {
		this.anunciar = anunciar;
		return "anunciarExclusao";
	}
	
	public String adicionar() {
		ag.adicionar(anunciar);
		return "anunciarGerenciamento";
	}
	
	public String atualizar() {
		ag.atualizar(anunciar);
		return "anunciarGerenciamento";
	}
	
	public String remover() {
		ag.remover(anunciar);
		return "anunciarGerenciamento";
	}

	public Anunciar getAnunciar() {
		return anunciar;
	}

	public void setAnunciar(Anunciar anunciar) {
		this.anunciar = anunciar;
	}

	public List<Anunciar> getAnunciars() {
		return ag.recuperarTodosPorNomeContendo(chave);
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}


}
