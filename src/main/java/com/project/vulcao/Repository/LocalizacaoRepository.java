package com.project.vulcao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.vulcao.Model.Localizacao;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long>{

	Localizacao findByContinente(String continente);

}
