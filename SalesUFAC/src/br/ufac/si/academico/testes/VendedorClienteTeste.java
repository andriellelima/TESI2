package br.ufac.si.academico.testes;

import java.security.NoSuchAlgorithmException;

import br.ufac.si.academico.entidades.*;
import br.ufac.si.academico.gerentes.UsuarioGerente;
import br.ufac.si.academico.gerentes.VendedorGerente;

public class VendedorClienteTeste {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		VendedorGerente vg = new VendedorGerente();
		UsuarioGerente ug = new UsuarioGerente();
		
		Vendedor v1 = new Vendedor("Mickael", "01642319279","mickaellabres@gmail.com", "28/08/1999", "123456");
		Cliente c1 = new Cliente("Andrielle Lima", "12345455900","andrielle@gmail.com", "00/00/1999", "654321");
		vg.adicionar(v1);
		ug.adicionar(c1);
		
		vg.encerrar();
		ug.encerrar();
	}
}
