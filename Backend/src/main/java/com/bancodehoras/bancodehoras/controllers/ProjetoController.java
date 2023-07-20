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

import com.bancodehoras.bancodehoras.models.Projeto;
import com.bancodehoras.bancodehoras.repositories.ProjetoRepository;

@RestController
@RequestMapping(value = "/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;

    @PutMapping(value = "/{id}/{var}")
    public ResponseEntity<Object> update(@RequestBody Projeto projeto, @PathVariable int id, 
    @PathVariable String var) {
        try {
            Projeto upProjeto = projetoRepository.findById(id).orElseThrow(NoSuchElementException::new);

            switch (var) {
                case "nome":
                    upProjeto.setNome(projeto.getNome());
                    break;
                case "cliente":
                    upProjeto.setCliente(projeto.getCliente());
                    break;
                case "valorHora":
                    upProjeto.setValorHora(projeto.getValorHora());
                    break;
            }

            upProjeto = projetoRepository.save(upProjeto);
            return ResponseEntity.ok(upProjeto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso não encontrado ou inexistente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
