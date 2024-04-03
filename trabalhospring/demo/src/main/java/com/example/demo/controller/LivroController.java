package com.example.demo.controller;




import com.example.demo.model.Livro;
import com.example.demo.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    LivroService livroservice;

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Livro livro, @PathVariable Long id) {
        //return livroService.atualizar(livro, id);
        LivroService livroService = null;
        if(livroservice.atualizar(livro, id) == null) {
            //O id não foi encontrado
            //return ResponseEntity.notFound().build();
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            //O id foi encontrado
            return ResponseEntity.ok(livro);
        }
    }

    @GetMapping("/{id}")
    public Optional<Livro> buscarPorID(@PathVariable Long id) {
        return livroservice.buscaPorID(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(livroservice.deletar(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @PostMapping
    public Livro criar(@Valid @RequestBody Livro livro) {
        return livroservice.criar(livro);
    }

    @GetMapping
    public List<Livro> listarLivros() {
        return livroservice.listarLivros();
    }

    @GetMapping("/verificardisponibilidade/{id}")
    public ResponseEntity<?> verificarDisponibilidade(@PathVariable Long id) {
        if (livroservice.verificarDisponibilidade(id)) {
            String mensagem ="Livro disponível.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem ="Livro não disponível.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }


}

