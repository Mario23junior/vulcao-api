package com.project.vulcao.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.vulcao.EntityDTO.VulcaoDTO;
import com.project.vulcao.Service.ServiceVulcao;

@RestController
@RequestMapping("/api/v1/geo/vulcaos")
public class ControllerVulcao {
  
	private ServiceVulcao serviceVulcao;
	
	public ControllerVulcao(ServiceVulcao serviceVulcao) {
		this.serviceVulcao = serviceVulcao;
	}
	
 	@GetMapping("/{id}")
	public ResponseEntity<VulcaoDTO> volcanoListId(@PathVariable("id") Long id) {
		return serviceVulcao.listVulcaoById(id);
	}
}
