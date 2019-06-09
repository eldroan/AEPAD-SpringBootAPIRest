package isi.aepad.service.impl;

import isi.aepad.domain.OrdenCompra;
import isi.aepad.repository.OrdenCompraRepository;
import isi.aepad.service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenCompraServiceDefault implements OrdenCompraService {

    @Autowired
    private OrdenCompraRepository repository;

    @Override
    public OrdenCompra buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public OrdenCompra guardar(OrdenCompra t) {
        return repository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<OrdenCompra> buscarTodas() {
        return repository.findAll();
    }
}
