package com.project.vulcao.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.vulcao.EntityDTO.LocalizacaoDTO;
import com.project.vulcao.Exceptions.ObjectValueEqualMessageError;
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
	
	
	public ResponseEntity<LocalizacaoDTO> saveDataLocalizao(LocalizacaoDTO localizacaoDto) {
		Localizacao localizacao = saveLocalizacao(modelMapper.map(localizacaoDto, Localizacao.class));
		return ResponseEntity
				            .status(HttpStatus.CREATED)
				            .body(modelMapper.map(localizacao, LocalizacaoDTO.class));
	}
	
	public Localizacao saveLocalizacao(Localizacao localizacao) {
		DonLetValueBeDuplicated(localizacao);
		return localizacaoRepository.save(localizacao);
	}
	
	public ResponseEntity<LocalizacaoDTO> updateDataLocalizacao(Long id, Localizacao localizacao) {
		DonLetValueBeDuplicated(localizacao);
 		Optional<Localizacao> listLocalizacao = localizacaoRepository.findById(id);
		if(listLocalizacao.isPresent()) {
			Localizacao localData = listLocalizacao.get();
			localData.setContinente(localizacao.getContinente());
			localData.setCooordenadas(localizacao.getCooordenadas());
			localData.setMetros(localizacao.getMetros());
			localData.setPais(localizacao.getPais());
			localData.setPes(localizacao.getPes());
			localizacaoRepository.save(localData);
			return ResponseEntity.ok(modelMapper.map(localData, LocalizacaoDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public void DonLetValueBeDuplicated(Localizacao localizacao) {
		Localizacao BucarLocalizacao = localizacaoRepository.findByContinente(localizacao.getContinente());
		if (BucarLocalizacao != null && BucarLocalizacao.getContinente() != localizacao.getContinente()) {
			throw new ObjectValueEqualMessageError(String.format("Continente %s já existe nesse cadastro", BucarLocalizacao.getContinente()));
		}
	}

	public Localizacao ValueIdExiste(Long id) {
		Optional<Localizacao> localizacao = localizacaoRepository.findById(id);
		if (localizacao.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return localizacao.get();
	}
}
















