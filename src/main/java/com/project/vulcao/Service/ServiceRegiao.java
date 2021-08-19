package com.project.vulcao.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.vulcao.EntityDTO.RegiaoDTO;
import com.project.vulcao.Model.Regiao;
import com.project.vulcao.Repository.RegiaoRepository;

@Service
public class ServiceRegiao {
  
	private RegiaoRepository regiaoRepository;
	private ModelMapper modelMapper;
	
	public ServiceRegiao(RegiaoRepository regiaoRepository, ModelMapper modelMapper) {
		this.regiaoRepository = regiaoRepository;
		this.modelMapper = modelMapper;
	}
	
	public ResponseEntity<RegiaoDTO> listRegiaoId(Long id) {
		Optional<Regiao> listRegiao = regiaoRepository.findById(id);
		if(listRegiao.isPresent()) {
			return ResponseEntity.ok(modelMapper.map(listRegiao.get(), RegiaoDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
