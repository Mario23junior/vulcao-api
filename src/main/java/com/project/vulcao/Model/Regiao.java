package com.project.vulcao.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Regiao {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tipoMontanha;
	private String alcanceMatriz;
	private String regiaoGeografica;
	private String pico;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoMontanha() {
		return tipoMontanha;
	}
	public void setTipoMontanha(String tipoMontanha) {
		this.tipoMontanha = tipoMontanha;
	}
	public String getAlcanceMatriz() {
		return alcanceMatriz;
	}
	public void setAlcanceMatriz(String alcanceMatriz) {
		this.alcanceMatriz = alcanceMatriz;
	}
	public String getRegiaoGeografica() {
		return regiaoGeografica;
	}
	public void setRegiaoGeografica(String regiaoGeografica) {
		this.regiaoGeografica = regiaoGeografica;
	}
	public String getPico() {
		return pico;
	}
	public void setPico(String pico) {
		this.pico = pico;
	}
	
	
} 
