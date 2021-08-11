package com.project.vulcao.Service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.vulcao.Model.Vulcao;
import com.project.vulcao.Repository.VulcaoRepository;

@Service
public class ServiceVulcao {
  
	private VulcaoRepository vulcaoRepository;
	
	public ServiceVulcao(VulcaoRepository vulcaoRepository) {
		 this.vulcaoRepository = vulcaoRepository;
	}
	
	
	public ResponseEntity<Vulcao> listVulcaoById (Long id) {
		Optional<Vulcao> listId = vulcaoRepository.findById(id);
		return listId.isPresent()
				      ? ResponseEntity.ok(listId.get())
				      : ResponseEntity.notFound().build();
	}
}
