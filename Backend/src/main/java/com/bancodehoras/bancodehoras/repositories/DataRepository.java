package com.bancodehoras.bancodehoras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancodehoras.bancodehoras.models.Data;

public interface DataRepository extends JpaRepository<Data, Integer> {   
}
