package com.project.vulcao.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.vulcao.EntityDTO.RegiaoDTO;
import com.project.vulcao.Model.Regiao;
import com.project.vulcao.Service.ServiceRegiao;

@RestController
@RequestMapping("/api/v1/geo/regiao")
public class ControllerRegiao {
  
	private ServiceRegiao serviceRegiao;
	
	public ControllerRegiao(ServiceRegiao serviceRegiao) {
		this.serviceRegiao = serviceRegiao;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RegiaoDTO> listIdRegiao(@PathVariable Long id) {
		return serviceRegiao.listRegiaoId(id);
	}
	
	@PostMapping
	public ResponseEntity<RegiaoDTO> saveByRegiao(@RequestBody RegiaoDTO regiaoDto) {
		return serviceRegiao.saveDataRegiao(regiaoDto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RegiaoDTO> updateRegiao(@RequestBody Regiao regiao, @PathVariable Long id) {
		return serviceRegiao.updateRegiao(id, regiao);
	}
}





















