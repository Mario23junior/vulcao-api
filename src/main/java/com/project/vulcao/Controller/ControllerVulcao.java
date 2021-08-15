package com.project.vulcao.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.vulcao.EntityDTO.VulcaoDTO;
import com.project.vulcao.Model.Vulcao;
import com.project.vulcao.Service.ServiceVulcao;

@RestController
@RequestMapping("/api/v1/geo/vulcaos")
public class ControllerVulcao {
  
	private ServiceVulcao serviceVulcao;
	
	public ControllerVulcao(ServiceVulcao serviceVulcao) {
		this.serviceVulcao = serviceVulcao;
	}
	
 	@GetMapping("/{id}")
 	public ResponseEntity<VulcaoDTO> listById(@PathVariable Long id){
 		return serviceVulcao.listVulcao(id);
   	}
 	
 	@PostMapping
 	public Vulcao vulcaoSave(@RequestBody Vulcao vulcao) {
 		return serviceVulcao.saveVulcao(vulcao);
 	}
 	
 	@PutMapping("/{id}")
 	public ResponseEntity<Vulcao> updateData(@PathVariable Long id, @RequestBody Vulcao vulcao) {
 		return serviceVulcao.updateData(id, vulcao);
   	}
 	
 	@DeleteMapping("/{id}")
 	public ResponseEntity<Vulcao> deleteVulcao(@PathVariable Long id) {
 		return serviceVulcao.deleteVulcao(id);
 	}
}