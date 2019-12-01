package br.ufac.si.academico.testes;

import java.security.NoSuchAlgorithmException;

import br.ufac.si.academico.entidades.Cliente;
import br.ufac.si.academico.entidades.Usuario;
import br.ufac.si.academico.entidades.Vendedor;
import br.ufac.si.academico.gerentes.UsuarioGerente;

public class UsuarioTeste {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		UsuarioGerente ug = new UsuarioGerente();
		
		Usuario a = ug.recuperar(1);
		System.out.println(a);
		System.out.println(a.getFuncao());
		
		Vendedor v1 = new Vendedor("Mickael", "01642319279","mickaellabres@gmail.com", "28/08/1999", "123456");
		Vendedor v2 = new Vendedor("Savyo", "05623559679","savyo@gmail.com", "40/58/8999", "128456");
		Cliente c1 = new Cliente("Andrielle Lima", "12345455900","andrielle@gmail.com", "00/00/1999", "654321");
		Cliente c2 = new Cliente("Hulk", "12345678900","verdao@gmail.com", "50/05/1999", "654321");

		
		ug.adicionar(v1);
		ug.adicionar(v2);
		ug.adicionar(c1);
		
		v1.setDataNascimento("55/55/1655");
		ug.atualizar(v1);
		
		ug.remover(c2);

		ug.recuperar(c1.getId());
		
		ug.encerrar();

		
	}
}
