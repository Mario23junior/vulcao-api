package com.project.vulcao.EntityDTO;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class VulcaoDTO {
 	
	@Length(max = 10, min = 3)
 	@NotNull(message = "Nome")
 	private String nome;
	
	@NotNull(message = "Ativo")	
	private Boolean ativo;

	@Length(max = 10, min = 3)
	@NotNull(message = "FormadoPor")	
	private String formadoPor;

	@NotNull(message = "UltimaErupcao")	
	private LocalDate ultimaErupcao;

	@Length(max = 1000, min = 3)
	@NotNull(message = "Descricao")	
	private String descricao;
	
 	private List<RegiaoDTO> regiaoDto;
 	private List<LocalizacaoDTO> localizacaoDto;	
 	private List<EstruturaDTO> estruturaDto;


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

	public List<RegiaoDTO> getRegiaoDto() {
		return regiaoDto;
	}

	public void setRegiaoDto(List<RegiaoDTO> regiaoDto) {
		this.regiaoDto = regiaoDto;
	}

	public List<LocalizacaoDTO> getLocalizacaoDto() {
		return localizacaoDto;
	}

	public void setLocalizacaoDto(List<LocalizacaoDTO> localizacaoDto) {
		this.localizacaoDto = localizacaoDto;
	}

	public List<EstruturaDTO> getEstruturaDto() {
		return estruturaDto;
	}

	public void setEstruturaDto(List<EstruturaDTO> estruturaDto) {
		this.estruturaDto = estruturaDto;
	}
}
