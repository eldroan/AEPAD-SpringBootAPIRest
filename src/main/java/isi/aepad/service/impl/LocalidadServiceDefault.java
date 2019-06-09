package isi.aepad.service.impl;

import isi.aepad.domain.Localidad;
import isi.aepad.repository.LocalidadRepository;
import isi.aepad.service.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadServiceDefault implements LocalidadService {

    @Autowired
    private LocalidadRepository repository;

    @Override
    public Localidad buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public Localidad guardar(Localidad t) {
        return repository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Localidad> buscarTodas() {
        return repository.findAll();
    }
}
