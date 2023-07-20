package com.bancodehoras.bancodehoras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancodehoras.bancodehoras.models.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {   
}
