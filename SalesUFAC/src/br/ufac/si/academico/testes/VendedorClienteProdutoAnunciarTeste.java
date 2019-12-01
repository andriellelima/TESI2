package br.ufac.si.academico.testes;


import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufac.si.academico.entidades.*;
import br.ufac.si.academico.gerentes.AnunciarGerente;
import br.ufac.si.academico.gerentes.ProdutoGerente;
import br.ufac.si.academico.gerentes.UsuarioGerente;
import br.ufac.si.academico.gerentes.VendedorGerente;

public class VendedorClienteProdutoAnunciarTeste {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		VendedorGerente vg = new VendedorGerente();
		UsuarioGerente ug = new UsuarioGerente();
		ProdutoGerente pg = new ProdutoGerente();
		AnunciarGerente ag = new AnunciarGerente();
		
		Vendedor v1 = new Vendedor("Mickael", "01642319279","mickaellabres@gmail.com", "28/08/1999", "123456");
		Vendedor v2 = new Vendedor("Savyo", "05623559679","savyo@gmail.com", "11/08/1999", "128456");
		Cliente c1 = new Cliente("Andrielle Lima", "12345455900","andrielle@gmail.com", "01/10/1999", "654321");
		Cliente c2 = new Cliente("Hulk", "12345678900","verdao@gmail.com", "29/05/1999", "654321");
		ug.adicionar(v1);
		ug.adicionar(c1);
		ug.adicionar(v2);
		ug.adicionar(c2);
		Produto p1 = new Produto(55, "Brigadeiro", "Brigadeiro de Churros,Beijinho,Café ",1, v1);
	    Produto p2 = new Produto(6, "Picole", "Sabores: Negresco,Chocolate,Leite Ninho ",2, v1);
	    pg.adicionar(p1);
		pg.adicionar(p2);
//		vg.remover(v2);
		ArrayList<Produto> P = new ArrayList<Produto>();
		P.add(p1);
		P.add(p2);
		
		Anunciar a1 = new Anunciar(v1,P , 22, "25/11/2019", "27/05/2020");
		ag.adicionar(a1);

		ag.encerrar();
		vg.encerrar();
		ug.encerrar();
		pg.encerrar();
	}
}
