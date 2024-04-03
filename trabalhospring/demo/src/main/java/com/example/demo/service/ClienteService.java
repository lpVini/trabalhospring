package com.example.demo.service;




import com.example.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import com.example.demo.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;




import java.util.Optional;
import java.util.List;




@Service
public class ClienteService {


    @Autowired
    ClienteRepository clienteRepository;


    public Cliente atualizar(Cliente cliente, Long id) {
        if(verificaID(id)) {
            //verdadeiro
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        return null;
    }


    private boolean verificaID(Long id) {
        if(clienteRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }


    public Optional<Cliente> buscaPorID(Long id) {

        return clienteRepository.findById(id);
    }


    public int qtdClientes() {

        return clienteRepository.findAll().size();
    }


    public boolean deletar(Long id) {
        if(verificaID(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    public Cliente criar(Cliente cliente) {

        return clienteRepository.save(cliente);
    }




    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}


