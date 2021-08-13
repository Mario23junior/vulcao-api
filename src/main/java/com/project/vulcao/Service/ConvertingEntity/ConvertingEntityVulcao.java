package com.project.vulcao.Service.ConvertingEntity;

import com.project.vulcao.EntityDTO.VulcaoDTO;
import com.project.vulcao.Model.Vulcao;

public class ConvertingEntityVulcao {
   	
	public static VulcaoDTO convertingToDTO(Vulcao vulcao) {
		VulcaoDTO vulcaoDto = new VulcaoDTO(vulcao.getAtivo(), vulcao.getFormadoPor(),
				vulcao.getUltimaErupcao(), vulcao.getDescricao());
		return vulcaoDto;
	}

}