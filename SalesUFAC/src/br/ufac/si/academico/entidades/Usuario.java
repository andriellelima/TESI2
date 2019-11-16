package br.ufac.si.academico.entidades;

import java.math.BigInteger;
import java.security.*;
import javax.persistence.*;

@Entity
@Table(name="usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name="Usuario.todos", 
		query="SELECT u FROM Usuario u"), 
	@NamedQuery(name="Usuario.todosPorNome", 
		query="SELECT u FROM Usuario u ORDER BY u.nome"),
	@NamedQuery(name="Usuario.todosPorNomeContendo", 
		query="SELECT u FROM Usuario u WHERE u.nome LIKE :termo ORDER BY u.nome")		
})
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
	@Column(nullable=false)
	private String senha;
	
	public Usuario() {}
	
	public Usuario(String nome, String cpf, String dataNascimento, String senha) throws NoSuchAlgorithmException {
//		this.id = id;
		MessageDigest m=MessageDigest.getInstance("MD5");
		m.update(senha.getBytes(),0,senha.length());
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.senha = new BigInteger(1,m.digest()).toString(16);
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
