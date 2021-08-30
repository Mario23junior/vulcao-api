package com.project.vulcao.Service.ResultDataDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.vulcao.EntityDTO.VulcaoDTO;
import com.project.vulcao.Model.Vulcao;
import com.project.vulcao.Repository.VulcaoRepository;

@Service
public class ResultData {
  
	private VulcaoRepository vulcaoRepository;
	private ModelMapper modelMapper;
	
	public ResultData(VulcaoRepository vulcaoRepository, ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
		this.vulcaoRepository = vulcaoRepository;
	}
	
	public List<VulcaoDTO> listAllInformationData() {
	    return ((List<Vulcao>) vulcaoRepository
	    		.findAll())
	    		.stream()
	    		.map(this::ConvertEntityAllDTO)
                .collect(Collectors.toList());

	}
	
	private VulcaoDTO ConvertEntityAllDTO(Vulcao vulcao) {
          VulcaoDTO vulcaoDataConvert = modelMapper.map(vulcao, VulcaoDTO.class);
 		return vulcaoDataConvert;
	}
	
	public List<VulcaoDTO> ListAllDataDTO() {
		List<VulcaoDTO> list = listAllInformationData();
		return list
				.stream()
				.collect(Collectors.toList());
	}
		
}











