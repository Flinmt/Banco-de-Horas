package com.bancodehoras.bancodehoras.models;

import java.time.Duration;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jornada")
public class Jornada {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalTime horaInicio;
    private LocalTime horaFinalizado;
    private Long total;

    @ManyToOne
    @JoinColumn(name = "id_projeto")
    private Projeto projeto;

    public Jornada() {
        horaInicio = LocalTime.now();
    }

    // Getts and Setts --------------------------------------------

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFinalizado() {
        return horaFinalizado;
    }

    public Long getTotal() {
        return total;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    // Getts and Setts --------------------------------------------

    public void finalizarJornada() {
        horaFinalizado = LocalTime.now();
        Duration diference = Duration.between(horaInicio, horaFinalizado);

        total = diference.getSeconds();
    }


}
