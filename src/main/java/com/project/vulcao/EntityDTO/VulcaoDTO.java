package com.project.vulcao.EntityDTO;

import java.time.LocalDate;

public class VulcaoDTO {

	private Boolean ativo;

	private String formadoPor;

	private LocalDate ultimaErupcao;

	private String descricao;

	public VulcaoDTO(Boolean ativo, String formadoPor, LocalDate ultimaErupcao, String descricao) {
		super();
 		this.ativo = ativo;
		this.formadoPor = formadoPor;
		this.ultimaErupcao = ultimaErupcao;
		this.descricao = descricao;
	}
 
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getFormadoPor() {
		return formadoPor;
	}

	public void setFormadoPor(String formadoPor) {
		this.formadoPor = formadoPor;
	}

	public LocalDate getUltimaErupcao() {
		return ultimaErupcao;
	}

	public void setUltimaErupcao(LocalDate ultimaErupcao) {
		this.ultimaErupcao = ultimaErupcao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
