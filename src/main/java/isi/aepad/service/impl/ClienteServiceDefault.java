package isi.aepad.service.impl;

import isi.aepad.domain.Cliente;
import isi.aepad.repository.ClienteRepository;
import isi.aepad.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceDefault implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public Cliente guardar(Cliente t) {
        return repository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Cliente> buscarTodas() {
        return repository.findAll();
    }
}
