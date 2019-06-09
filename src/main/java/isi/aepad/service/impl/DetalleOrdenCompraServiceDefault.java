package isi.aepad.service.impl;

import isi.aepad.domain.Cliente;
import isi.aepad.domain.DetalleOrdenCompra;
import isi.aepad.repository.ClienteRepository;
import isi.aepad.repository.DetalleOrdenCompraRepository;
import isi.aepad.service.ClienteService;
import isi.aepad.service.DetalleOrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleOrdenCompraServiceDefault implements DetalleOrdenCompraService {

    @Autowired
    private DetalleOrdenCompraRepository repository;

    @Override
    public DetalleOrdenCompra buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el DetalleOrdenCompra con ID "+id));
    }

    @Override
    public DetalleOrdenCompra guardar(DetalleOrdenCompra t) {
        return repository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<DetalleOrdenCompra> buscarTodas() {
        return repository.findAll();
    }
}
