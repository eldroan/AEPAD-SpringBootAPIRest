package isi.aepad.service;

import isi.aepad.domain.OrdenCompra;

import java.util.List;

public interface OrdenCompraService {

    OrdenCompra buscarPorId(Integer id);

    OrdenCompra guardar(OrdenCompra t);

    void borrar(Integer id);

    List<OrdenCompra> buscarTodas();
}
