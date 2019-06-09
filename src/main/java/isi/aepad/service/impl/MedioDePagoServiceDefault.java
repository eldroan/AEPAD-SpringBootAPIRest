package isi.aepad.service.impl;

import isi.aepad.domain.Cliente;
import isi.aepad.domain.MedioDePago;
import isi.aepad.repository.ClienteRepository;
import isi.aepad.repository.MedioDePagoRepository;
import isi.aepad.service.ClienteService;
import isi.aepad.service.MedioDePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedioDePagoServiceDefault implements MedioDePagoService {

    @Autowired
    private MedioDePagoRepository repository;

    @Override
    public MedioDePago buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public MedioDePago guardar(MedioDePago t) {
        return repository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<MedioDePago> buscarTodas() {
        return repository.findAll();
    }
}
