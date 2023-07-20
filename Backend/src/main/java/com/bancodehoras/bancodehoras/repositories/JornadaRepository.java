package com.bancodehoras.bancodehoras.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancodehoras.bancodehoras.models.Jornada;
import com.bancodehoras.bancodehoras.models.Projeto;

public interface JornadaRepository extends JpaRepository<Jornada, Integer> {

    List<Jornada> findByProjeto(Projeto projeto);
}
