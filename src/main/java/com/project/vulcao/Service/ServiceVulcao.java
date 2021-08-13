package com.project.vulcao.Service;

import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.vulcao.EntityDTO.VulcaoDTO;
import com.project.vulcao.Exceptions.ObjectValueEqualMessageError;
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
	
	public Vulcao salvarVulcao(Vulcao vulcao) {
 		Vulcao saveVulcao = vulcaoRepository.save(vulcao);
		  if(saveVulcao == null) {
			ResponseEntity.ok(ConvertingEntityVulcao.convertingToDTO(saveVulcao));
		}else {			
			ResponseEntity.notFound().build();
		}
		  return saveVulcao;
	}

	public Vulcao saveByVulcao(Vulcao vulcao) {
		DonLetValueBeDuplicated(vulcao);
		Vulcao saveEntity = salvarVulcao(vulcao);
		return saveEntity;
	}
	
	public void DonLetValueBeDuplicated(Vulcao vulcao){
		Vulcao BucarVulcao = vulcaoRepository.findByNome(vulcao.getNome());
		if(BucarVulcao != null && BucarVulcao.getId() != vulcao.getId()) {
			throw new ObjectValueEqualMessageError(String.format("Vulcao %s já esta cadastrado", vulcao.getNome()));
		}
	}
	
	public Vulcao DonLetValueIdExiste(Long id) {
		Optional<Vulcao> vulcao = vulcaoRepository.findById(id);
		if(vulcao.isPresent()) {
		   throw new EmptyResultDataAccessException(1);
		}
		return vulcao.get();
				
	}
	
	
 	
}








