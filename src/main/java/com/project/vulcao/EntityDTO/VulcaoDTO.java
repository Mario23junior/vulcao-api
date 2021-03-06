package com.project.vulcao.EntityDTO;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

public class VulcaoDTO {
 	
	@Length(max = 10, min = 3)
 	@NotNull(message = "Nome")
 	private String nome;
	
	@NotNull(message = "Ativo")	
	private Boolean ativo;

	@Length(max = 100, min = 3)
	@NotNull(message = "FormadoPor")	
	private String formadoPor;

	@NotNull(message = "UltimaErupcao")	
	private LocalDate ultimaErupcao;

	@Length(max = 1000, min = 3)
	@NotNull(message = "Descricao")	
	private String descricao;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
 	private List<RegiaoDTO> regiao;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
 	private List<LocalizacaoDTO> localizacao;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
 	private List<EstruturaDTO> estrutura;

	
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

 	public List<RegiaoDTO> getRegiao() {
		return regiao;
	}
	
	public void setRegiao(List<RegiaoDTO> regiao) {
		this.regiao = regiao;
	}


	public List<LocalizacaoDTO> getLocalizacao() {
		return localizacao;
	}


	public void setLocalizacao(List<LocalizacaoDTO> localizacao) {
		this.localizacao = localizacao;
	}


	public List<EstruturaDTO> getEstrutura() {
		return estrutura;
	}


	public void setEstrutura(List<EstruturaDTO> estrutura) {
		this.estrutura = estrutura;
	}

	
	


}
