package com.infomendes.brewer.model.enums;

public enum TipoPessoa {

	FISICA(0, "Fisica"), JURIDICA(1, "Juridica");

	private String  descricao;
	private Integer codigo;

	private TipoPessoa(Integer codigo, String descricao) {
		this.setCodigo(codigo);
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
