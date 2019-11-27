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
		query="SELECT u FROM Usuario u WHERE u.nome LIKE :termo ORDER BY u.nome")	,
	@NamedQuery(name="Usuario.poremail", 
	query="SELECT u FROM Usuario u WHERE u.email LIKE :termo ORDER BY u.email"),
	@NamedQuery(name = "Usuario.login",
	query = "SELECT c FROM Usuario c WHERE c.email = :email AND c.senha = :senha")
})
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // gerador de ID automatico
	private int id;
	@Column(nullable=false, length=80)
	private String nome;
	@Column(nullable=false, length=11, unique = true) //apenas numeros e nao aceita cpf igual ao que estao cadastrado.

	private String cpf;
	@Column(unique=true, nullable=false)
	private String email;
	@Column(nullable=false, length=10) // dd/mm/aaaa
	private String dataNascimento;
	@Column(nullable=false)
	private String senha;
	@Column(nullable=false)
	private String Funcao;
	
	public Usuario() {}
	
	public Usuario(String nome, String cpf, String email, String dataNascimento, String senha, String funcao) throws NoSuchAlgorithmException {
//		this.id = id;
		MessageDigest m=MessageDigest.getInstance("MD5");
		m.update(senha.getBytes(),0,senha.length());
		this.nome = nome;
		this.cpf = cpf;
		this.email = email.trim().toLowerCase();
		this.dataNascimento = dataNascimento;
		this.senha = new BigInteger(1,m.digest()).toString(16);
		this.Funcao = funcao;
	}
	@Transient
    public static final String login = "Usuario.login";       

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.trim().toLowerCase();;
	}
	

	public String getFuncao() {
		return Funcao;
	}

	public void setFuncao(String funcao) {
		Funcao = funcao;
	}

	public static String getLogin() {
		return login;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", dataNascimento="
				+ dataNascimento + ", senha=" + senha + "]";
	}
	

	
	
	
	
	
}
