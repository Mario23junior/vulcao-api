package com.project.vulcao.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
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
	private ModelMapper modelMapper;

	public ServiceVulcao(VulcaoRepository vulcaoRepository, ModelMapper modelMapper) {
		this.vulcaoRepository = vulcaoRepository;
		this.modelMapper = modelMapper;
 	}

	public ResponseEntity<VulcaoDTO> listVulcao(Long id){
		Optional<Vulcao> vulcaoId = vulcaoRepository.findById(id);
		if(vulcaoId.isPresent()) {
			return ResponseEntity.ok(modelMapper.map(vulcaoId.get(), VulcaoDTO.class));
		}else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<VulcaoDTO> saveVulcao(VulcaoDTO vulcaoDto) {
		 Vulcao saveId = saveVulcao(modelMapper.map(vulcaoDto, Vulcao.class));
 		 return ResponseEntity
				            .status(HttpStatus.CREATED)
 				            .body(modelMapper.map(saveId, VulcaoDTO.class));	 
	}
	
	public Vulcao saveVulcao(Vulcao vulcao) {
		DonLetValueBeDuplicated(vulcao);
		return vulcaoRepository.save(vulcao);
	}
	
	public ResponseEntity<Vulcao> updateData(Long id, Vulcao vulcao) {
		DonLetValueBeDuplicated(vulcao);
		Optional<Vulcao> listVulcao = vulcaoRepository.findById(id);
		if(listVulcao.isPresent()) {
			Vulcao vulcaoConsult = listVulcao.get();
			vulcaoConsult.setNome(vulcao.getNome());
			vulcaoConsult.setAtivo(vulcao.getAtivo());
			vulcaoConsult.setFormadoPor(vulcao.getFormadoPor());
			vulcaoConsult.setUltimaErupcao(vulcao.getUltimaErupcao());
			vulcaoRepository.save(vulcaoConsult);
			return new ResponseEntity<>(vulcaoConsult,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Vulcao> deleteVulcao(Long id) {
		Optional<Vulcao> vulcaoDelete = vulcaoRepository.findById(id);
		if(vulcaoDelete.isPresent()) {
			vulcaoRepository.delete(vulcaoDelete.get());
			return new ResponseEntity<>(HttpStatus.OK);
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

