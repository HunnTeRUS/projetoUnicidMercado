package com.unicid.model;

public class Estoque {
	
	public long id;
	
	public String nome;
	
	public String marca;

	public String descricao;
	
	public double preco;
	
	public long idCategoria;
	
	public Estoque() {}

	public Estoque(long id, String nome, String marca, String descricao, double preco, long idCategoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.descricao = descricao;
		this.preco = preco;
		this.idCategoria = idCategoria;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}
}
