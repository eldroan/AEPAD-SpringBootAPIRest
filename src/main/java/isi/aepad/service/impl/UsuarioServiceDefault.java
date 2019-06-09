package isi.aepad.service.impl;

import isi.aepad.domain.Cliente;
import isi.aepad.domain.Usuario;
import isi.aepad.repository.ClienteRepository;
import isi.aepad.repository.UsuarioRepository;
import isi.aepad.service.ClienteService;
import isi.aepad.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceDefault implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public Usuario guardar(Usuario t) {
        return repository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Usuario> buscarTodas() {
        return repository.findAll();
    }
}
