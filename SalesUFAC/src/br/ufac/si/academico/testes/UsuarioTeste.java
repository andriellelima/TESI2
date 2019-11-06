package br.ufac.si.academico.testes;

import br.ufac.si.academico.entidades.Usuario;
import br.ufac.si.academico.gerentes.UsuarioGerente;

public class UsuarioTeste {

	public static void main(String[] args) {
		
		UsuarioGerente ug = new UsuarioGerente();
		
		Usuario us1 = new Usuario("Mickael", "01642319279", "28/08/1999", "123456");
		Usuario us2 = new Usuario("Savyo S", "12345678900", "00/00/1999", "42357");
		Usuario us3 = new Usuario("Andrielle Lima", "12345455900", "00/00/1999", "654321");
		Usuario us4 = new Usuario("Andrielfef", "ef345455900", "00/00/1999", "654321");

		
		ug.adicionar(us1);
		ug.adicionar(us2);
		ug.adicionar(us3);
		
		us2.setDataNascimento("55/55/1655");
		ug.atualizar(us2);
		
		ug.remover(us4);

		ug.recuperar(us1.getId());
		
		ug.encerrar();

		
	}
}
