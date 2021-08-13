package com.project.vulcao.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class Vulcao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private Boolean ativo;

	private String formadoPor;

	private LocalDate ultimaErupcao;

	@Length(max = 1000, min = 10)
	private String descricao;

	public Vulcao() {
		// TODO Auto-generated constructor stub
	}

	public Vulcao(Long id, String nome, Boolean ativo, String formadoPor, LocalDate ultimaErupcao,
			@Length(max = 1000, min = 10) String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.ativo = ativo;
		this.formadoPor = formadoPor;
		this.ultimaErupcao = ultimaErupcao;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
