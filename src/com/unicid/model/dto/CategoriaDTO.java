package com.unicid.model.dto;

public class CategoriaDTO {
	
	public long id;
	
	public String nome;
		
	public CategoriaDTO() {}
	
	public CategoriaDTO(long id, String nome) {
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
	
}
