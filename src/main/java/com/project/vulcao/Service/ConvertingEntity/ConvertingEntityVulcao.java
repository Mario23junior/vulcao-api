package com.project.vulcao.Service.ConvertingEntity;

import org.modelmapper.ModelMapper;

import com.project.vulcao.EntityDTO.VulcaoDTO;
import com.project.vulcao.Model.Vulcao;

public class ConvertingEntityVulcao {

 	private ModelMapper modelMapper;
	
	public VulcaoDTO convertToDto(Vulcao vulcao) {
		VulcaoDTO vulcaoDto = modelMapper.map(vulcao, VulcaoDTO.class);
		return vulcaoDto;
	}

}
