package br.ufac.si.academico.entidades;

import javax.persistence.*;

@Entity
@Table(name="produtos")

public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // gerador de ID automatico
	private long Id;
	@Column(nullable=false)
	private long quantidade;
	@Column(nullable=false, length=20)
	private String nome;
	@Column(nullable=false, length=120)
	private String descricao;
	@Column(nullable=false)
	private double avaliacao;
	@ManyToOne()
	@JoinColumn(name="vendedor")
	private Vendedor vendedor;
	
	public Produto(long quantidade, String nome, String descricao, Vendedor vendedor) {
		this.quantidade = quantidade;
		this.nome = nome;
		this.descricao = descricao;
//		this.avaliacao = avaliacao;
		this.vendedor = vendedor;
	}
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	
	

}
