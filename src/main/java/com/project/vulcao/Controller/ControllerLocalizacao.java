package com.project.vulcao.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.vulcao.EntityDTO.LocalizacaoDTO;
import com.project.vulcao.Service.ServiceLocalizacao;

@RestController
@RequestMapping("/api/v1/geo/localizacao")
public class ControllerLocalizacao {
   
	private ServiceLocalizacao serviceLocalizacao;
	
	public ControllerLocalizacao(ServiceLocalizacao serviceLocalizacao) {
		this.serviceLocalizacao = serviceLocalizacao;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LocalizacaoDTO> listEstrutura(@PathVariable Long id) {
		return serviceLocalizacao.listByIdData(id);
	}
	
	@PostMapping
	public ResponseEntity<LocalizacaoDTO> saveLoacalizao(@RequestBody LocalizacaoDTO localizacaoDto) {
		return serviceLocalizacao.saveDataLocalizao(localizacaoDto);
	}
}
