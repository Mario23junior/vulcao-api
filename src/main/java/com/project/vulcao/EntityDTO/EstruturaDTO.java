package com.project.vulcao.EntityDTO;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class EstruturaDTO {

	@Length(max = 50, min = 3)
 	@NotNull(message = "TipoLava")
	private String tipoLava;
	
	@Length(max = 50, min = 3)
 	@NotNull(message = "formatoPercorencia")
	private String formatoPercorencia;
	
	@Length(max = 50, min = 3)
 	@NotNull(message = "FormatoPerfil")
	private String formacaoPerfil;

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
