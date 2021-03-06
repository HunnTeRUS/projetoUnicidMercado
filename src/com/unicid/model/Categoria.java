package com.unicid.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	public long id;
	
	public String nome;
	
	public List<Estoque> idsProdutos = new ArrayList<Estoque>();
	
	public Categoria() {}
	
	public Categoria(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Estoque> getIdsProdutos() {
		return idsProdutos;
	}

	public void setIdsProdutos(List<Estoque> idsProdutos) {
		this.idsProdutos = idsProdutos;
	}
	
}
