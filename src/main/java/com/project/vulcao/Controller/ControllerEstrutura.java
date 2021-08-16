package com.project.vulcao.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.vulcao.EntityDTO.EstruturaDTO;
import com.project.vulcao.Service.ServiceEstrutura;

@RestController
@RequestMapping("/api/v1/geo/estrutura")
public class ControllerEstrutura {
  
	private ServiceEstrutura serviceEstrutura;
	
	public ControllerEstrutura(ServiceEstrutura serviceEstrutura) {
		this.serviceEstrutura = serviceEstrutura;
 	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstruturaDTO> listEstrutura(@PathVariable Long id){
		return serviceEstrutura.listEstrutura(id);
	}
	
	@PostMapping
	public ResponseEntity<EstruturaDTO> saveEstrutura(@RequestBody EstruturaDTO estruturaDTO){
		return serviceEstrutura.saveEstrutura(estruturaDTO);
	}

}
