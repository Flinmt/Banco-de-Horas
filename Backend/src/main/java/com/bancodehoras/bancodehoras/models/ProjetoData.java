package com.bancodehoras.bancodehoras.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "projeto_data")
public class ProjetoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_projeto")
    protected Projeto projeto;

    @OneToOne
    @JoinColumn(name = "id_data")
    protected Data data;

    public ProjetoData(Projeto projeto, Data data) {
        this.projeto = projeto;
        this.data = data;
    }

    // Getts and Setts --------------------------------------------

    public int getId() {
        return id;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public Data getData() {
        return data;
    }
}
