package com.project.vulcao.EntityDTO;

import java.time.LocalDate;

public class VulcaoDTO {
 	
	private Long id;
	
 	private String nome;
	
	private Boolean ativo;

	private String formadoPor;

	private LocalDate ultimaErupcao;

	private String descricao;

	public VulcaoDTO() {
 	}
	
	public VulcaoDTO(String nome, Boolean ativo, String formadoPor, LocalDate ultimaErupcao,
			String descricao) {
		super();
		this.nome = nome;
		this.ativo = ativo;
		this.formadoPor = formadoPor;
		this.ultimaErupcao = ultimaErupcao;
		this.descricao = descricao;
	}	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
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
