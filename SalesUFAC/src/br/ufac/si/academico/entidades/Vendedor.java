package br.ufac.si.academico.entidades;

import javax.persistence.*;
@Entity
@Table(name="vendedores")
@PrimaryKeyJoinColumn(name="id")
public class Vendedor extends Usuario {

	public Vendedor(String nome, String cpf, String dataNascimento, String senha) {
		super(nome, cpf, dataNascimento, senha);
	}
	private String Função = "Vendedor";
	private double Avaliacao;
	
	public String getFunção() {
		return Função;
	}
	public void setFunção(String função) {
		Função = função;
	}
	public double getAvaliacao() {
		return Avaliacao;
	}
	public void setAvaliacao(double avaliacao) {
		Avaliacao = avaliacao;
	}
	
	
}
