package com.example.demo.controller;


import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteservice;


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Cliente cliente, @PathVariable Long id) {
        //return clienteService.atualizar(cliente, id);
        ClienteService clienteService = null;
        if(clienteservice.atualizar(cliente, id) == null) {
            //O id não foi encontrado
            //return ResponseEntity.notFound().build();
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            //O id foi encontrado
            return ResponseEntity.ok(cliente);
        }
    }


    @GetMapping("/{id}")
    public Optional<Cliente> buscarPorID(@PathVariable Long id) {
        return clienteservice.buscaPorID(id);
    }


    @GetMapping("/qtd")
    public int qtdClientes() {
        return clienteservice.qtdClientes();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(clienteservice.deletar(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }


    @PostMapping
    public Cliente criar(@Valid @RequestBody Cliente cliente) {
        return clienteservice.criar(cliente);
    }


    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteservice.listarClientes();
    }
}

