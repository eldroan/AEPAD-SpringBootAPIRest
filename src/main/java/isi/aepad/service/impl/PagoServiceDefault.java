package isi.aepad.service.impl;

import isi.aepad.domain.Pago;
import isi.aepad.repository.PagoRepository;
import isi.aepad.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceDefault implements PagoService {

    @Autowired
    private PagoRepository repository;

    @Override
    public Pago buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public Pago guardar(Pago t) {
        return repository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Pago> buscarTodas() {
        return repository.findAll();
    }
}
