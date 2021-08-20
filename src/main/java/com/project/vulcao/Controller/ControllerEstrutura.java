package com.project.vulcao.Controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.vulcao.EntityDTO.EstruturaDTO;
import com.project.vulcao.Model.Estrutura;
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
	public ResponseEntity<EstruturaDTO> saveEstrutura(@RequestBody @Valid EstruturaDTO estruturaDTO){
		return serviceEstrutura.saveEstrutura(estruturaDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EstruturaDTO> updateData(@PathVariable Long id,@RequestBody @Valid Estrutura estrutura) {
		return serviceEstrutura.updateEstrutura(id, estrutura);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<EstruturaDTO> deleteEstrutura(@PathVariable Long id){
		return serviceEstrutura.deleteEstrutura(id);
	}

}
