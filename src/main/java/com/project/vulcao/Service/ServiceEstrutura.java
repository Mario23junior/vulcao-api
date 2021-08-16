package com.project.vulcao.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.vulcao.EntityDTO.EstruturaDTO;
import com.project.vulcao.Model.Estrutura;
import com.project.vulcao.Repository.EstruturaRepository;

 
@Service
public class ServiceEstrutura {
  
	private EstruturaRepository estruturaRepository;
	private ModelMapper modelMapper;
	
	public ServiceEstrutura(EstruturaRepository estruturaRepository, ModelMapper modelMapper) {
		this.estruturaRepository = estruturaRepository;
		this.modelMapper = modelMapper;
	}
	
	public ResponseEntity<EstruturaDTO> listEstrutura(Long id) {
		Optional<Estrutura> estruturaId = estruturaRepository.findById(id);
		if(estruturaId.isPresent()) {
			return ResponseEntity.ok(modelMapper.map(estruturaId.get(), EstruturaDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}
