package com.project.vulcao.DTOController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.vulcao.EntityDTO.VulcaoDTO;
import com.project.vulcao.Service.ResultDataDTO.ResultData;

@RestController
@RequestMapping("/api/v1/geo/allData/")
public class ControllerListAllFinal {
  
	private ResultData resultData;
	
	public ControllerListAllFinal(ResultData resultData) {
		this.resultData = resultData;
	}
	
	@GetMapping
	public List<VulcaoDTO> list() {
		return resultData.listAllData();
	}
}
