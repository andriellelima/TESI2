package br.ufac.si.academico.entidades;

import java.security.NoSuchAlgorithmException;

import javax.persistence.*;
@Entity
@Table(name="clientes")
@PrimaryKeyJoinColumn(name="id")
@NamedQueries({
	@NamedQuery(name="Cliente.todos", 
		query="SELECT c FROM Cliente c"), 
	@NamedQuery(name="Cliente.todosPorNome", 
		query="SELECT c FROM Cliente c ORDER BY c.nome"),
	@NamedQuery(name="Cliente.todosPorNomeContendo", 
		query="SELECT c FROM Cliente c WHERE c.nome LIKE :termo ORDER BY c.nome"),
	@NamedQuery(name="Cliente.porid", 
		query="SELECT c FROM Cliente c WHERE c.id = :termo")
})
public class Cliente extends Usuario {

	public Cliente() {}
	
	public Cliente(String nome, String cpf,String email, String dataNascimento, String senha) throws NoSuchAlgorithmException {
		super(nome, cpf,email, dataNascimento, senha);
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
