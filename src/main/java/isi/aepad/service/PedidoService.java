package isi.aepad.service;

import isi.aepad.domain.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido buscarPorId(Integer id);

    Pedido guardar(Pedido t);

    void borrar(Integer id);

    List<Pedido> buscarTodas();
}
