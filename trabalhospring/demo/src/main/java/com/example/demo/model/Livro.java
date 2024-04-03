package com.example.demo.model;
import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String nomeAutor;
    private String categoria;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Boolean disponivel;

    public Livro() {

    }

    public Livro(Long id, String titulo, String nomeAutor, String categoria, boolean disponivel) {
        this.id = id;
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.categoria = categoria;
        this.disponivel = disponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getdisponivel() {return disponivel;}

    public void setdisponivel(Boolean disponivel) {this.disponivel = disponivel;}


}


