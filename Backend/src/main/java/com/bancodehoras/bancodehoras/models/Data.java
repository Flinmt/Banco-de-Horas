package com.bancodehoras.bancodehoras.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "data")
@NoArgsConstructor
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dataInicio;
    private LocalDate dataLimite;
    private LocalDate dataFinalizacao;

    public Data(LocalDate dataLimite) {
        dataInicio = LocalDate.now();
        this.dataLimite = dataLimite;
    }

    // Getts and Setts --------------------------------------------

    public int getId() {
        return this.id;
    }

    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public LocalDate getDataLimite() {
        return this.dataLimite;
    }

    public LocalDate getDataFinalizacao() {
        return this.dataFinalizacao;
    }

    // Getts and Setts --------------------------------------------

    public void finalizarProjeto() {
        dataFinalizacao = LocalDate.now(); 
    }
}
