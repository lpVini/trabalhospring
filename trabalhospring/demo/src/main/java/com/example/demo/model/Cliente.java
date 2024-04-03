package com.example.demo.model;


import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean disponibilidade;


    public Cliente() {
    }


    public Cliente(String nome, String email, Long id, Boolean disponibilidade) {
        super(nome, email);
        this.id = id;
        this.disponibilidade = disponibilidade;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Boolean getDisponibilidade() {
        return disponibilidade;
    }


    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}


