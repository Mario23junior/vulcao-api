package com.project.vulcao.Service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.vulcao.EntityDTO.VulcaoDTO;
import com.project.vulcao.Model.Vulcao;
import com.project.vulcao.Repository.VulcaoRepository;
import com.project.vulcao.Service.ConvertingEntity.ConvertingEntityVulcao;

@Service
public class ServiceVulcao {
	
	private VulcaoRepository vulcaoRepository;
	public ConvertingEntityVulcao convertingEntityVulcao;

	public ServiceVulcao(VulcaoRepository vulcaoRepository) {
		this.vulcaoRepository = vulcaoRepository;
	}

	public ResponseEntity<VulcaoDTO> listVulcaoById(Long id) {
		Optional<Vulcao> listId = vulcaoRepository.findById(id);
		return listId.isPresent() ? 
				ResponseEntity.ok(ConvertingEntityVulcao.convertingToDTO(listId.get()))
				: ResponseEntity.notFound().build();
	}

	public Vulcao saveByVulcao(Vulcao vulcao) {
		Vulcao saveEntity = vulcaoRepository.save(vulcao);
		return saveEntity;
	}
	
}
