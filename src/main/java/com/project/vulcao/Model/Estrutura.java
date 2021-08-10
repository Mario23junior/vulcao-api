package com.project.vulcao.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estrutura {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tipoLava;
	private String formatoPercorencia;
	private String formacaoPerfil;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoLava() {
		return tipoLava;
	}
	public void setTipoLava(String tipoLava) {
		this.tipoLava = tipoLava;
	}
	public String getFormatoPercorencia() {
		return formatoPercorencia;
	}
	public void setFormatoPercorencia(String formatoPercorencia) {
		this.formatoPercorencia = formatoPercorencia;
	}
	public String getFormacaoPerfil() {
		return formacaoPerfil;
	}
	public void setFormacaoPerfil(String formacaoPerfil) {
		this.formacaoPerfil = formacaoPerfil;
	}
	
	
}
