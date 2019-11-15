package br.ufac.si.academico.entidades;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="anuncios")
public class Anunciar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // gerador de ID automatico
	private int id;
	@ManyToOne
	@JoinColumn(name="vendedor")
	private Vendedor vendedor;
	@ManyToMany
	@JoinColumn(name="anuncio")
	private List <Produto> produtos;
	@Column(nullable=false)
	private long quantProdutoDisp;
	@Column(nullable=false)
	private String dtinicio;
	@Column(nullable=false)
	private String dtfim;
	
	
	
	public Anunciar(Vendedor vendedor, ArrayList<Produto> produtos, long quantProdutoDisp, String dtinicio, String dtfim)  {
		this.vendedor = vendedor;
		this.produtos = produtos;
		this.quantProdutoDisp = quantProdutoDisp;
		this.dtinicio = dtinicio;
		this.dtfim = dtfim;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public long getQuantProdutoDisp() {
		return quantProdutoDisp;
	}
	public void setQuantProdutoDisp(long quantProdutoDisp) {
		this.quantProdutoDisp = quantProdutoDisp;
	}
	public String getDtinicio() {
		return dtinicio;
	}
	public void setDtinicio(String dtinicio) {
		this.dtinicio = dtinicio;
	}
	public String getDtfim() {
		return dtfim;
	}
	public void setDtfim(String dtfim) {
		this.dtfim = dtfim;
	}
	
	

	
	
}
