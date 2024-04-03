package com.example.demo.model;


import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Bibliotecario extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numClienteGerenciado;


    public Bibliotecario() {
    }


    public Bibliotecario(String nome, String email, Long id, int numUsuarioGerenciado) {
        super(nome, email);
        this.id = id;
        this.numClienteGerenciado = numUsuarioGerenciado;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public int getNumClienteGerenciado() {
        return numClienteGerenciado;
    }


    public void setNumUsuarioGerenciado(int numClienteGerenciado) {
        this.numClienteGerenciado = numClienteGerenciado;
    }


}

