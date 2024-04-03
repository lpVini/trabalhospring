package com.example.demo.controller;




import com.example.demo.model.Bibliotecario;
import com.example.demo.service.BibliotecarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/bibliotecario")
public class BibliotecarioController {


    @Autowired
    BibliotecarioService bibliotecarioService;


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Bibliotecario bibliotecario, @PathVariable Long id) {
        //return bibliotecarioService.atualizar(bibliotecario, id);
        BibliotecarioService bibliotecarioService = null;
        if(bibliotecarioService.atualizar(bibliotecario, id) == null) {
            //O id não foi encontrado
            //return ResponseEntity.notFound().build();
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            //O id foi encontrado
            return ResponseEntity.ok(bibliotecario);
        }
    }
    @GetMapping("/{id}")
    public Optional<Bibliotecario> buscarPorID(@PathVariable Long id) {
        return bibliotecarioService.buscaPorID(id);
    }

    @PostMapping
    public Bibliotecario criar(@Valid @RequestBody Bibliotecario bibliotecario) {
        return bibliotecarioService.criar(bibliotecario);
    }

    @GetMapping
    public List<Bibliotecario> listarBibliotecarios() {
        return bibliotecarioService.listarBibliotecarios();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(bibliotecarioService.deletar(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/{id}/num-clientes-gerenciados")
    public ResponseEntity<?> obterNumClienteGerenciado(@PathVariable Long id) {
        int numClientesGerenciados = bibliotecarioService.numClienteGerenciado(id);
        return ResponseEntity.ok(numClientesGerenciados);
    }

}

