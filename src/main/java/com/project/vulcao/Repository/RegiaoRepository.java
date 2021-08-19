package com.project.vulcao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.vulcao.Model.Regiao;

public interface RegiaoRepository extends JpaRepository<Regiao, Long>{

	Regiao findByRegiaoGeografica(String regiaoGeografica);

}
