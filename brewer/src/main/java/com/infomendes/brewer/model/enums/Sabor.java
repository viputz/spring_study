package com.infomendes.brewer.model.enums;

public enum Sabor {

	ADOCICADA("Adocicada"), 
	AMARGA("Amarga"), 
	FORTE("Forte"), 
	FRUTADA("Frutada"), 
	SUAVE("Suave");

	private String descricao;

	private Sabor(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
