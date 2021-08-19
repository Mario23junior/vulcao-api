package com.project.vulcao.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.vulcao.EntityDTO.RegiaoDTO;
import com.project.vulcao.Exceptions.ObjectValueEqualMessageError;
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
	
	public ResponseEntity<RegiaoDTO> saveDataRegiao(RegiaoDTO regiaoDto) {
	   Regiao regiaoId = saveRegiao(modelMapper.map(regiaoDto, Regiao.class));
	   return ResponseEntity
			              .status(HttpStatus.CREATED)
			              .body(modelMapper.map(regiaoId, RegiaoDTO.class));
	}

	private Regiao saveRegiao(Regiao regiao) {
		DonLetValueBeDuplicated(regiao);
 		return regiaoRepository.save(regiao);
	}
	
	public ResponseEntity<RegiaoDTO> updateRegiao(Long id, Regiao regiao) {
		DonLetValueBeDuplicated(regiao);
 		Optional<Regiao> listRegiao = regiaoRepository.findById(id);
		if(listRegiao.isPresent()) {
			Regiao regiaoConsult = listRegiao.get();
			regiaoConsult.setAlcanceMatriz(regiao.getAlcanceMatriz());
			regiaoConsult.setRegiaoGeografica(regiao.getRegiaoGeografica());
			regiaoConsult.setTipoMontanha(regiao.getTipoMontanha());
			regiaoConsult.setPico(regiao.getPico());
			regiaoRepository.save(regiaoConsult);
			return ResponseEntity.ok(modelMapper.map(regiaoConsult, RegiaoDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Regiao> deleteByRegiao(Long id) {
		Optional<Regiao> regiaoDelete = regiaoRepository.findById(id);
		if(regiaoDelete.isPresent()) {
			regiaoRepository.delete(regiaoDelete.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public void DonLetValueBeDuplicated(Regiao regiao) {
		Regiao BucarRegiao = regiaoRepository.findByRegiaoGeografica(regiao.getRegiaoGeografica());
		if (BucarRegiao != null && BucarRegiao.getId() != regiao.getId()) {
			throw new ObjectValueEqualMessageError(String.format("informação de regionalização  %s já esta cadastrado", regiao.getRegiaoGeografica()));
		}
	}

	public Regiao ValueIdExiste(Long id) {
		Optional<Regiao> regiao = regiaoRepository.findById(id);
		if (regiao.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return regiao.get();
	}
	
}
















