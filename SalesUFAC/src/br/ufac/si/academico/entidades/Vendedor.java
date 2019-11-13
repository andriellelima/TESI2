package br.ufac.si.academico.entidades;

import java.security.NoSuchAlgorithmException;

import javax.persistence.*;
@Entity
@Table(name="vendedores")
@PrimaryKeyJoinColumn(name="id")
public class Vendedor extends Usuario {

	public Vendedor(String nome, String cpf, String dataNascimento, String senha) throws NoSuchAlgorithmException {
		super(nome, cpf, dataNascimento, senha);
	}
	private String Funcao = "Vendedor";
	private double Avaliacao;
	
	public String getFunção() {
		return Funcao;
	}
	public void setFunção(String função) {
		Funcao = função;
	}
	public double getAvaliacao() {
		return Avaliacao;
	}
	public void setAvaliacao(double avaliacao) {
		Avaliacao = avaliacao;
	}
	
	
}
