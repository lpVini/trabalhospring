package com.example.demo.service;

import com.example.demo.model.Bibliotecario;
import com.example.demo.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;



@Service
public class BibliotecarioService {
    @Autowired
    BibliotecarioRepository bibliotecarioRepository;


    public Bibliotecario atualizar(Bibliotecario bibliotecario , Long id) {
        if(verificaID(id)) {
            //verdadeiro
            bibliotecario.setId(id);
            return bibliotecarioRepository.save(bibliotecario);
        }
        return null;
    }
    private boolean verificaID(Long id) {
        if(bibliotecarioRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    public Optional<Bibliotecario> buscaPorID(Long id) {
        return bibliotecarioRepository.findById(id);
    }


    public Bibliotecario criar(Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }


    public List<Bibliotecario> listarBibliotecarios() {
        return bibliotecarioRepository.findAll();
    }


    public boolean deletar(Long id) {
        if(verificaID(id)) {
            bibliotecarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public int numClienteGerenciado(Long idBibliotecario) {
        Optional<Bibliotecario> bibliotecarioOptional = bibliotecarioRepository.findById(idBibliotecario);
        if (bibliotecarioOptional.isPresent()) {
            Bibliotecario bibliotecario = bibliotecarioOptional.get();
            return bibliotecario.getNumClienteGerenciado();
        } else {
            // Se o bibliotecário com o ID fornecido não existir, você pode lançar uma exceção
            throw new IllegalArgumentException("Bibliotecário não encontrado com ID: " + idBibliotecario);
        }
    }


}

