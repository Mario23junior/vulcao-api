package com.project.vulcao.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.vulcao.EntityDTO.EstruturaDTO;
import com.project.vulcao.Exceptions.ObjectValueEqualMessageError;
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
	
	public ResponseEntity<EstruturaDTO> saveEstrutura(EstruturaDTO estruturaDTO) {
		Estrutura saveId = saveEntity(modelMapper.map(estruturaDTO, Estrutura.class));
		return ResponseEntity
				           .status(HttpStatus.CREATED)
				           .body(modelMapper.map(saveId, EstruturaDTO.class));
	}
	

	public ResponseEntity<EstruturaDTO> updateEstrutura(Long id, Estrutura estrutura) {
		DonLetValueBeDuplicated(estrutura);
		Optional<Estrutura> listEstrutura = estruturaRepository.findById(id);
		if(listEstrutura.isPresent()) {
			Estrutura estruturaConsult = listEstrutura.get();
			estruturaConsult.setFormacaoPerfil(estrutura.getFormacaoPerfil());
			estruturaConsult.setFormatoPercorencia(estrutura.getFormatoPercorencia());
			estruturaConsult.setTipoLava(estrutura.getTipoLava());
			estruturaRepository.save(estruturaConsult);
			return ResponseEntity.ok(modelMapper.map(estruturaConsult, EstruturaDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public Estrutura saveEntity(Estrutura estrutura) {
		DonLetValueBeDuplicated(estrutura);
 		return estruturaRepository.save(estrutura);
	}
	
	public void DonLetValueBeDuplicated(Estrutura estrutura) {
		Estrutura buscaEstrutura = estruturaRepository.findByTipoLava(estrutura.getTipoLava());
		if(buscaEstrutura != null && buscaEstrutura.getId() != estrutura.getId()) {
			throw new ObjectValueEqualMessageError(String.format("o tipo %s já se encontra cadastrado", estrutura.getTipoLava()));
		}
	}
}
