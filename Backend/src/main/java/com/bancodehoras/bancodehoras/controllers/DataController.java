package com.bancodehoras.bancodehoras.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancodehoras.bancodehoras.models.Data;
import com.bancodehoras.bancodehoras.repositories.DataRepository;

@RestController
@RequestMapping(value = "/data")
public class DataController {
    
    @Autowired
    private DataRepository dataRepository;

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> update(@RequestBody Data data, @PathVariable int id) {
        try {
            Data upData = dataRepository.findById(id).orElseThrow(NoSuchElementException::new);;
            upData.setDataLimite(data.getDataLimite());
            upData = dataRepository.save(upData);
    
            return ResponseEntity.ok(upData);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso não encontrado ou inexistente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
