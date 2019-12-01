package br.ufac.si.academico.testes;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.si.academico.entidades.Anunciar;
import br.ufac.si.academico.entidades.Cliente;
import br.ufac.si.academico.entidades.Produto;
import br.ufac.si.academico.entidades.Venda;
import br.ufac.si.academico.entidades.Vendedor;
import br.ufac.si.academico.gerentes.AnunciarGerente;
import br.ufac.si.academico.gerentes.ClienteGerente;
import br.ufac.si.academico.gerentes.ProdutoGerente;
import br.ufac.si.academico.gerentes.UsuarioGerente;
import br.ufac.si.academico.gerentes.VendaGerente;
import br.ufac.si.academico.gerentes.VendedorGerente;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

public class vendaTeste {

	public static void main(String[] args) throws NoSuchAlgorithmException {
			VendedorGerente vg = new VendedorGerente();
			UsuarioGerente ug = new UsuarioGerente();
			ClienteGerente cg = new ClienteGerente();
			ProdutoGerente pg = new ProdutoGerente();
			AnunciarGerente ag = new AnunciarGerente();
			VendaGerente veng = new VendaGerente();
	        List<Produto> produtos;

	        Vendedor v1 = new Vendedor("Macilon Araujo", "20102319279","macilon@gmail.com", "10/10/1979", "123456");
	        ug.adicionar(v1);
			Cliente c1 = new Cliente("Andrielle Lima", "12345455900","andrielle@gmail.com", "01/10/1999", "654321");
			ug.adicionar(c1);
	        Produto p1 = new Produto(55, "Brigadeiro", "Brigadeiro de Churros,Beijinho,Café ",1, v1);
	        Produto p2 = new Produto(6, "Picole", "Sabores: Negresco,Chocolate,Leite Ninho ",2, v1);
	        pg.adicionar(p1);
	        pg.adicionar(p2);
	        System.out.println("========================Ṕroduto===================");
	        System.out.println("Vendedor:"+v1.toString());
			ArrayList<Produto> P = new ArrayList<Produto>();
	        P.add(p1);
	        P.add(p2);
//	        pg.remover(p1);

	        System.out.println("Produtos Adicionados:");
	        produtos = pg.recuperarTodos();
	        for(Produto produto : produtos) {
	            System.out.println(" "+produtos.toString());
	        }
	        
	        System.out.println("========================Anunciar===================");

	        System.out.println("Parte 1");
	        
	        Anunciar a1 = new Anunciar(v1, P, p1.getQuantidade()+p2.getQuantidade(), "25/12/2019", "28/12/2019","Entrada do RU", "11:15");
	        System.out.println("Parte 2");

	        ag.adicionar(a1);
	        System.out.println("Parte 3");

	        System.out.println(a1.toString());
	        System.out.println("Parte 4");
	        
	        System.out.println("========================Venda===================");
	        System.out.println("Parte 1");

	        Venda vv1 = new Venda("25/05/2011" , p2, 2, v1, c1);
	        System.out.println("Parte 2");

	        veng.adicionar(vv1);
	        System.out.println("Parte 3");

	        System.out.println(vv1.toString());
	        System.out.println("Parte 4");
	        
//	        vg.remover(v1);

	        veng.encerrar();

	        
	        ag.encerrar();


//	        vg.adicionar(v1);


	        cg.encerrar();
	        pg.encerrar();
	        vg.encerrar();
	        ug.encerrar();

	}

}
