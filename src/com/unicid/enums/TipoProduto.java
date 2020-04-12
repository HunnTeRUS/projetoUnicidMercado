package com.unicid.enums;

public enum TipoProduto {
    ALIMENTICIO(1, "Alimenticio"),
    LIMPEZA(2, "Limpeza"),
	COSMETICOS(3, "Cosmeticos"),
	PET(4, "Pet"),
	DIVERSOS(5, "Diversos");

	private int cod;

	private String nome;

	TipoProduto(int cod, String nome) {
		this.cod = cod;
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public String getNome() {
		return nome;
	}
}
