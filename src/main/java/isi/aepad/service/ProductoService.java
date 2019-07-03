package isi.aepad.service;

import isi.aepad.domain.Producto;

import java.util.List;

public interface ProductoService {

    Producto buscarPorId(Integer id);

    Producto guardar(Producto t);

    void borrar(Integer id);

    List<Producto> buscarRandom(int i) throws Exception;
}
