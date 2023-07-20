package com.bancodehoras.bancodehoras.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "projeto")
@NoArgsConstructor
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cliente;
    private double valorHora;
    private double valorTotal;
    private boolean finalizado;

    public Projeto(String nome, String cliente, double valorHora) {
        this.nome = nome;
        this.cliente = cliente;
        this.valorHora = valorHora;
        valorTotal = 0.0;
        finalizado = false;
    }

    // Getts and Setts --------------------------------------------

    public int getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getValorHora() {
        return this.valorHora;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    // Getts and Setts --------------------------------------------

    public void finalizarProjeto(Double valorTotal) {
        if (finalizado == false) {
            this.valorTotal = valorTotal;
            finalizado = true; 
        }
    }
}
