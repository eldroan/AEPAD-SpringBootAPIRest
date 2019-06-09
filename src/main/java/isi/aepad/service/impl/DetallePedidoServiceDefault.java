package isi.aepad.service.impl;

import isi.aepad.domain.Cliente;
import isi.aepad.domain.DetallePedido;
import isi.aepad.repository.ClienteRepository;
import isi.aepad.repository.DetallePedidoRepository;
import isi.aepad.service.ClienteService;
import isi.aepad.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceDefault implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository repository;

    @Override
    public DetallePedido buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el DetallePedido con ID "+id));
    }

    @Override
    public DetallePedido guardar(DetallePedido t) {
        return repository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<DetallePedido> buscarTodas() {
        return repository.findAll();
    }
}
