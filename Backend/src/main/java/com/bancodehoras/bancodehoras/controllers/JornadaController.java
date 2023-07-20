package com.bancodehoras.bancodehoras.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancodehoras.bancodehoras.models.Jornada;
import com.bancodehoras.bancodehoras.models.Projeto;
import com.bancodehoras.bancodehoras.repositories.JornadaRepository;
import com.bancodehoras.bancodehoras.repositories.ProjetoRepository;

@RestController
@RequestMapping(value = "/jornadas")
public class JornadaController {
    
    @Autowired
    JornadaRepository repository;
    @Autowired
    ProjetoRepository projetoRepository;

    @PostMapping(value = "/new")
    public ResponseEntity<Object> insert(@RequestBody Jornada jornada){
        try {
            Jornada result = repository.save(jornada);
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping
    public List<Jornada> findAll(){
        List<Jornada> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/projeto/{id}")
    public List<Jornada> findAllByProject(@PathVariable int id){
        Projeto projeto = projetoRepository.findById(id).get();
        List<Jornada> result = repository.findByProjeto(projeto);
        return result;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id){
        try {
            Jornada result = repository.findById(id).orElseThrow(NoSuchElementException::new);
            return ResponseEntity.ok(result);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso não encontrado ou inexistente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PutMapping(value = "/finalizar/{id}")
    public ResponseEntity<Object> finalizarJornada(@PathVariable int id){
        try {
            Jornada result = repository.findById(id).orElseThrow(NoSuchElementException::new);
            result.finalizarJornada();
            result = repository.save(result);

            return ResponseEntity.ok(result);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso não encontrado ou inexistente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id){
        try {
            repository.deleteById(id);
            return ResponseEntity.ok("Deletado com Sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping(value = "/dropprojeto/{id}")
    public ResponseEntity<Object> deleteByProjeto(@PathVariable int id){
        try {
            List<Jornada> jornadas = findAllByProject(id);
            repository.deleteAll(jornadas);

            return ResponseEntity.ok("Deletados com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
