package br.ufac.si.academico.testes;

import br.ufac.si.academico.entidades.*;
import br.ufac.si.academico.gerentes.ProdutoGerente;
import br.ufac.si.academico.gerentes.UsuarioGerente;
import br.ufac.si.academico.gerentes.VendedorGerente;

public class VendedorClienteProdutoTeste {

	public static void main(String[] args) {
		VendedorGerente vg = new VendedorGerente();
		UsuarioGerente ug = new UsuarioGerente();
		ProdutoGerente pg = new ProdutoGerente();
		
		Vendedor v1 = new Vendedor("Mickael", "01642319279", "28/08/1999", "123456");
		Vendedor v2 = new Vendedor("Savyo", "05623559679", "40/58/8999", "128456");
		Cliente c1 = new Cliente("Andrielle Lima", "12345455900", "00/00/1999", "654321");
		Cliente c2 = new Cliente("Hulk", "12345678900", "50/05/1999", "654321");
		vg.adicionar(v1);
		ug.adicionar(c1);
		ug.adicionar(v2);
		ug.adicionar(c2);
		Produto p1 = new Produto(55, "Brigadeiro", "Brigadeiro de varios sabores e varias coresbalabalablabalballksd", v1);
		Produto p2 = new Produto(6, "Picole", "Picole é geldo", v2);
		pg.adicionar(p1);
		pg.adicionar(p2);

		
		vg.encerrar();
		ug.encerrar();
	}
}
