package isi.aepad.service;

import isi.aepad.domain.DetalleOrdenCompra;

import java.util.List;

public interface DetalleOrdenCompraService {

    DetalleOrdenCompra buscarPorId(Integer id);

    DetalleOrdenCompra guardar(DetalleOrdenCompra t);

    void borrar(Integer id);

    List<DetalleOrdenCompra> buscarTodas();
}
