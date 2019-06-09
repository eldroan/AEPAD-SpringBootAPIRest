package isi.aepad.service.impl;

import isi.aepad.domain.Producto;
import isi.aepad.repository.ProductoRepository;
import isi.aepad.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceDefault implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    public Producto buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public Producto guardar(Producto t) {
        return repository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Producto> buscarTodas() {
        return repository.findAll();
    }
}
