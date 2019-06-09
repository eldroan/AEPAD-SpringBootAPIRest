package isi.aepad.service;

import isi.aepad.domain.DetallePedido;

import java.util.List;

public interface DetallePedidoService {

    DetallePedido buscarPorId(Integer id);

    DetallePedido guardar(DetallePedido t);

    void borrar(Integer id);

    List<DetallePedido> buscarTodas();
}
