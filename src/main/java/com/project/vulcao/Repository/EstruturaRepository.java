package com.project.vulcao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.vulcao.Model.Estrutura;

public interface EstruturaRepository extends JpaRepository<Estrutura, Long>{

	Estrutura findByTipoLava(String tipoLava);

}
