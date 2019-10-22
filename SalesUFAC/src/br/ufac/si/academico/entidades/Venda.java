package br.ufac.si.academico.entidades;

import javax.persistence.*;

@Entity
public class Venda {

	private long id;
	private String dataVenda;
	private String produto;
	private int quantidade;
	private double valor;
	private int pontosFidelidade;
}
