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

public class ProdutoTeste {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        VendedorGerente vg = new VendedorGerente();
        UsuarioGerente ug = new UsuarioGerente();
        ProdutoGerente pg = new ProdutoGerente();
        List<Produto> produtos;

        Vendedor v1 = new Vendedor("Macilon Araujo", "20102319279","macilon@gmail.com", "10/10/1979", "123456");
        vg.adicionar(v1);
        Produto p1 = new Produto(55, "Brigadeiro", "Brigadeiro de Churros,Beijinho,Café ",1, v1);
        Produto p2 = new Produto(6, "Picole", "Sabores: Negresco,Chocolate,Leite Ninho ",2, v1);
        pg.adicionar(p1);
        pg.adicionar(p2);
        System.out.println("========================Ṕroduto===================");
        System.out.println("Vendedor:"+v1.getNome());
        ArrayList<Produto> P = new ArrayList<Produto>();
        P.add(p1);
        P.add(p2);
        pg.remover(p1);

        System.out.println("Produtos Adicionados:");
        produtos = pg.recuperarTodos();
        for(Produto produto : produtos) {
            System.out.println(" "+produtos.toString());
        }

//        vg.adicionar(v1);



        pg.encerrar();
        vg.encerrar();
        ug.encerrar();
    }
}