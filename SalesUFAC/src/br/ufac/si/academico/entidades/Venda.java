package br.ufac.si.academico.entidades;

import javax.persistence.*;

@Entity
@Table(name="vendas")

//@NamedQueries({
//	@NamedQuery(name="Venda.todos", 
//	query="SELECT v FROM Venda v"), 
//	@NamedQuery(name="Venda.todosPorNome", 
//	query="SELECT v FROM Venda v ORDER BY v.nome"),
//	@NamedQuery(name="Venda.todosPorNomeContendo", 
//	query="SELECT v FROM Venda v WHERE v.nome LIKE :termo ORDER BY v.nome")		
//})

public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // gerador de ID automatico
	private long id;
	
	@Column(nullable=false, length=10)
	private String dataVenda;
	@ManyToOne
	@JoinColumn(name="produto")
	private Produto produto;
	@Column(nullable=false)
	private int quantidade;
	@Column(nullable=false)
	private double valor;
	//	private int pontosFidelidade;
	@ManyToOne
	@JoinColumn(name="vendedor")
	private Vendedor vendedor;
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;

	public Venda() {}

	public Venda(String dataVenda, Produto produto, int quantidade, Vendedor vendedor, Cliente cliente) {
		this.dataVenda = dataVenda;
		this.produto = produto;
		this.quantidade = quantidade;
		double valor = produto.getValor()*quantidade;
		this.valor = valor;
		//		this.pontosFidelidade = pontosFidelidade;
		this.vendedor = vendedor;
		this.cliente = cliente;

		cliente.setFidelidade((int) (cliente.getFidelidade()+quantidade));
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	//	public int getPontosFidelidade() {
	//		return pontosFidelidade;
	//	}
	//	public void setPontosFidelidade(int pontosFidelidade) {
	//		this.pontosFidelidade = pontosFidelidade;
	//	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", dataVenda=" + dataVenda + ", produto=" + produto + ", quantidade=" + quantidade
				+ ", valor=" + valor + ", vendedor=" + vendedor.getNome() + ", cliente=" + cliente.getNome() + "]";
	}





}
