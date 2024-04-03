package com.example.demo.service;





import com.example.demo.model.Livro;
import com.example.demo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    public Livro atualizar(Livro livro, Long id) {
        if(verificaID(id)) {
            //verdadeiro
            livro.setId(id);
            return livroRepository.save(livro);
        }
        return null;
    }

    private boolean verificaID(Long id) {
        if(livroRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    public Optional<Livro> buscaPorID(Long id) {

        return livroRepository.findById(id);
    }

    public boolean deletar(Long id) {
        if(verificaID(id)) {
            livroRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Livro criar(Livro livro) {

        return livroRepository.save(livro);
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public boolean verificarDisponibilidade(Long id) {
        if(verificaID(id)) {
            livroRepository.findById(id);
            return true;
        } else {
            return false;
        }
    }


}


