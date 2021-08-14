package com.project.vulcao.Service;

import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

	public ResponseEntity<Vulcao> listVulcao(Long id){
		Optional<Vulcao> vulcaoId = vulcaoRepository.findById(id);
		if(vulcaoId.isPresent()) {
			return new ResponseEntity<Vulcao>(vulcaoId.get(),HttpStatus.OK);
		}else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public void DonLetValueBeDuplicated(Vulcao vulcao) {
		Vulcao BucarVulcao = vulcaoRepository.findByNome(vulcao.getNome());
		if (BucarVulcao != null && BucarVulcao.getId() != vulcao.getId()) {
			throw new ObjectValueEqualMessageError(String.format("Vulcao %s já esta cadastrado", vulcao.getNome()));
		}
	}

	public Vulcao ValueIdExiste(Long id) {
		Optional<Vulcao> vulcao = vulcaoRepository.findById(id);
		if (vulcao.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return vulcao.get();

	}

}
