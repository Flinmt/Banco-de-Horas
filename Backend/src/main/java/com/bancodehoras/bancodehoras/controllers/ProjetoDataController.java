package com.bancodehoras.bancodehoras.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancodehoras.bancodehoras.models.ProjetoData;
import com.bancodehoras.bancodehoras.repositories.ProjetoDataRepository;

@RestController
@RequestMapping(value = "/projetodata")
public class ProjetoDataController {
    
    @Autowired
    private ProjetoDataRepository repository;

    @GetMapping
    public List<ProjetoData> findAll(){
        List<ProjetoData> result = repository.findAll();
        return result;
    }
}
