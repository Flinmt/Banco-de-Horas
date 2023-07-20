package com.bancodehoras.bancodehoras.dtos;

import java.time.LocalDate;

import com.bancodehoras.bancodehoras.models.Projeto;

public class ProjetoDto extends Projeto {

    private LocalDate dataLimite;
    private LocalDate dataInicio;

    public ProjetoDto(String nome, String cliente, double valorHora, LocalDate dataLimite) {
        super(nome, cliente, valorHora);
        this.dataLimite = dataLimite;
    }


    // Getts and Setts --------------------------------------------

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    // Getts and Setts --------------------------------------------
}
