package br.ufac.si.academico.entidades;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // gerador de ID automatico
	private int id;
	@Column(nullable=false, length=80)
	private String nome;
	@Column(nullable=false, length=11, unique = true) //apenas numeros e nao aceita cpf igual ao que estao cadastrado.

	private String cpf;
	@Column(nullable=false, length=10) // dd/mm/aaaa
	private String dataNascimento;
	@Column(nullable=false, length=15)
	private String senha;
	public Usuario(String nome, String cpf, String dataNascimento, String senha) {
//		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
