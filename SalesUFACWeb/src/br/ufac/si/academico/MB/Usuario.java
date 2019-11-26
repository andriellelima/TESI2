package br.ufac.si.academico.MB;

public class Usuario {
	
	private String login;
	private String nome;
	private String senha;
	
	public Usuario() {
		
	}
	
	public Usuario(String login,String nome, String senha) {
		this.login = login;
		this.nome = nome;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", nome=" + nome + ", senha=" + senha + "]";
	}


	
}
