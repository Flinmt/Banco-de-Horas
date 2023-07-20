package com.bancodehoras.bancodehoras.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancodehoras.bancodehoras.dtos.ProjetoDto;
import com.bancodehoras.bancodehoras.models.Data;
import com.bancodehoras.bancodehoras.models.Jornada;
import com.bancodehoras.bancodehoras.models.Projeto;
import com.bancodehoras.bancodehoras.models.ProjetoData;
import com.bancodehoras.bancodehoras.repositories.DataRepository;
import com.bancodehoras.bancodehoras.repositories.ProjetoDataRepository;
import com.bancodehoras.bancodehoras.repositories.ProjetoRepository;

@RestController
@RequestMapping(value = "/sistema")
public class ProjetoDtoController {

    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private DataRepository dataRepository;
    @Autowired
    private ProjetoDataRepository projetoDataRepository;
    @Autowired
    private JornadaController jornadaController;

    @PostMapping(value = "/new")
    public ResponseEntity<Object> addProjeto(@RequestBody ProjetoDto projetoDto){
        try {
            Projeto newProjeto = new Projeto(projetoDto.getNome(), projetoDto.getCliente(), 
                projetoDto.getValorHora());
            Data newData = new Data(projetoDto.getDataLimite());
    
            Projeto projetoResult = projetoRepository.save(newProjeto);
            Data dataResult = dataRepository.save(newData);

            ProjetoData projetoData = new ProjetoData(projetoResult, dataResult);
            ProjetoData result = projetoDataRepository.save(projetoData);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Falhou");
        }
    }

    @PutMapping(value = "/finalizar/{id}")
    public ResponseEntity<Object> finalizarProjeto(@PathVariable int id) {
        try {
            ProjetoData projetoFinalizado = projetoDataRepository.findById(id).orElseThrow(NoSuchElementException::new);
            List<Jornada> jornadas = jornadaController.findAllByProject(projetoFinalizado.getProjeto().getId());

            double totalTrabalhado = 0;
            for (Jornada jornada : jornadas) {
                totalTrabalhado += (double) jornada.getTotal()/3600;
            }
            double valorTotal = totalTrabalhado*projetoFinalizado.getProjeto().getValorHora();

            projetoFinalizado.getProjeto().finalizarProjeto(valorTotal);
            projetoFinalizado.getData().finalizarProjeto();

            projetoRepository.save(projetoFinalizado.getProjeto());
            dataRepository.save(projetoFinalizado.getData());
            
            projetoFinalizado = projetoDataRepository.findById(id).orElseThrow(NoSuchElementException::new);
            return ResponseEntity.ok(projetoFinalizado);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso não encontrado ou inexistente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> deletarProjeto(@PathVariable int id) {
        try {
            ProjetoData projetoDeletado = projetoDataRepository.findById(id).orElseThrow(NoSuchElementException::new);
            projetoDataRepository.deleteById(projetoDeletado.getId());
            jornadaController.deleteByProjeto(projetoDeletado.getProjeto().getId());
            dataRepository.deleteById(projetoDeletado.getData().getId());
            projetoRepository.deleteById(projetoDeletado.getProjeto().getId());
            
            
            return ResponseEntity.ok("Deletado com Sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso não encontrado ou inexistente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
