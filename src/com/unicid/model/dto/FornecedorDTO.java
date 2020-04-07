package com.unicid.model.dto;

public class FornecedorDTO {
	
	public long id;
	
	public String nome;
	
	public String localizacao;
	
	public int tipoFornecimento;
		
	public FornecedorDTO() {}

	public FornecedorDTO(long id, String nome, String localizacao, int tipoFornecimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.localizacao = localizacao;
		this.tipoFornecimento = tipoFornecimento;
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

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public int getTipoFornecimento() {
		return tipoFornecimento;
	}

	public void setTipoFornecimento(int tipoFornecimento) {
		this.tipoFornecimento = tipoFornecimento;
	}

	
}
