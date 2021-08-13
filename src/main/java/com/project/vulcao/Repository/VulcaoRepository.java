package com.project.vulcao.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.vulcao.Model.Vulcao;

public interface VulcaoRepository extends JpaRepository<Vulcao, Long>{
   
   Vulcao findByNome(String nome);
   Optional<Vulcao> findById(Long id);
}
