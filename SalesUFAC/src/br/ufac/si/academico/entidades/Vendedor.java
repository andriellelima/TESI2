package br.ufac.si.academico.entidades;

import java.security.NoSuchAlgorithmException;

import javax.persistence.*;
@Entity
@Table(name="vendedores")
@PrimaryKeyJoinColumn(name="id")
@NamedQueries({
	@NamedQuery(name="Vendedor.todos", 
		query="SELECT v FROM Vendedor v"), 
	@NamedQuery(name="Vendedor.todosPorNome", 
		query="SELECT v FROM Vendedor v ORDER BY v.nome"),
	@NamedQuery(name="Vendedor.todosPorNomeContendo", 
		query="SELECT v FROM Vendedor v WHERE v.nome LIKE :termo ORDER BY v.nome"),
	@NamedQuery(name="Vendedor.porid", 
	query="SELECT v FROM Vendedor v WHERE v.id = :termo")
})
public class Vendedor extends Usuario {
	
	public Vendedor() {}

	public Vendedor(String nome, String cpf, String email, String dataNascimento, String senha) throws NoSuchAlgorithmException {
		super(nome, cpf, email, dataNascimento, senha, "Vendedor");
	}
	private double Avaliacao;
	private int quantaval; //quantas avalições ja teve
	
	public int getQuantaval() {
		return quantaval;
	}
	public void setQuantaval(int quantaval) {
		this.quantaval = quantaval;
	}
	public double getAvaliacao() {
		return Avaliacao;
	}
	public void setAvaliacao(double avaliacao) {
		Avaliacao = avaliacao;
		setQuantaval(getQuantaval()+1);
	}

	
	@Override
	public String toString() {
		return "Vendedor [Avaliacao=" + Avaliacao + ", quantaval=" + quantaval + ", getId()=" + getId() + ", getNome()="
				+ getNome() + ", getCpf()=" + getCpf() + ", getDataNascimento()=" + getDataNascimento()
				+ ", getSenha()=" + getSenha() + ", getEmail()=" + getEmail() + ", getFuncao()=" + getFuncao() + "]";
	}
	
	
	
}
