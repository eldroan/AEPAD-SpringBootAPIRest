package isi.aepad.service.impl;

import isi.aepad.domain.Cliente;
import isi.aepad.domain.Pedido;
import isi.aepad.repository.ClienteRepository;
import isi.aepad.repository.PedidoRepository;
import isi.aepad.service.ClienteService;
import isi.aepad.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceDefault implements PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Override
    public Pedido buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public Pedido guardar(Pedido t) {
        return repository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Pedido> buscarTodas() {
        return repository.findAll();
    }
}
