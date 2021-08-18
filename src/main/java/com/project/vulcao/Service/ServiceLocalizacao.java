package com.project.vulcao.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.vulcao.EntityDTO.LocalizacaoDTO;
import com.project.vulcao.Model.Localizacao;
import com.project.vulcao.Repository.LocalizacaoRepository;

@Service
public class ServiceLocalizacao {
   
	private ModelMapper modelMapper;
	private LocalizacaoRepository localizacaoRepository;
	
	public ServiceLocalizacao(ModelMapper modelMapper, LocalizacaoRepository localizacaoRepository) {
		this.localizacaoRepository = localizacaoRepository;
		this.modelMapper = modelMapper;
	}
	
	public ResponseEntity<LocalizacaoDTO> listByIdData(Long id) {
		Optional<Localizacao> localizacao = localizacaoRepository.findById(id);
		if(localizacao.isPresent()) {
			return ResponseEntity.ok(modelMapper.map(localizacao.get(), LocalizacaoDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
