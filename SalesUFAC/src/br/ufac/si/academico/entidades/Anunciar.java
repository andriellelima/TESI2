package br.ufac.si.academico.entidades;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="anuncios")

//@NamedQueries({
//	@NamedQuery(name="Anunciar.todos", 
//		query="SELECT a FROM Anunciar a"), 
//	@NamedQuery(name="Anunciar.todosPorNome", 
//		query="SELECT a FROM Anunciar a ORDER BY a.nome"),
////	@NamedQuery(name="Anunciar.todosPorNomeContendo", 
//		query="SELECT a FROM Anunciar a WHERE a.nome LIKE :termo ORDER BY a.nome")		
//})
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
	private String local;
	@Column(nullable=false)
	private String dtinicio;
	@Column(nullable=false)
	private String dtfim;
	@Column(nullable=false)
	private String hora;
	
	
	public Anunciar() {}
	
	public Anunciar(Vendedor vendedor, ArrayList<Produto> produtos, long quantProdutoDisp, String dtinicio, String dtfim, String local, String horario)  {
		this.vendedor = vendedor;
		this.produtos = produtos;
		this.quantProdutoDisp = quantProdutoDisp;
		this.dtinicio = dtinicio;
		this.dtfim = dtfim;
		this.local = local;
		this.hora = horario;
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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Anunciar [id=" + id + ", vendedor=" + vendedor.getNome() + ", produtos=" + produtos + ", quantProdutoDisp="
				+ quantProdutoDisp + ", local=" + local + ", dtinicio=" + dtinicio + ", dtfim=" + dtfim + ", hora="
				+ hora + "]";
	}
	
	

	
	
}
