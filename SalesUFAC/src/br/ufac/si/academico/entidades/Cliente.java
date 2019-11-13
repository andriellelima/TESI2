package br.ufac.si.academico.entidades;

import java.security.NoSuchAlgorithmException;

import javax.persistence.*;
@Entity
@Table(name="clientes")
@PrimaryKeyJoinColumn(name="id")
public class Cliente extends Usuario {

	public Cliente(String nome, String cpf, String dataNascimento, String senha) throws NoSuchAlgorithmException {
		super(nome, cpf, dataNascimento, senha);
	}
	private String Função = "Cliente";
	private int Fidelidade;
	
	public String getFunção() {
		return Função;
	}
	public void setFunção(String função) {
		Função = função;
	}
	public double getFidelidade() {
		return Fidelidade;
	}
	public void setFidelidade(int fidelidade) {
		Fidelidade = fidelidade;
	}
	
//	public void avaliarVendedor(double nota) {
//		Vendedor.setAvaliacao(nota);
//	}
}
