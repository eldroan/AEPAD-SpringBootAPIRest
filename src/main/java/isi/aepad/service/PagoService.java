package isi.aepad.service;

import isi.aepad.domain.Pago;

import java.util.List;

public interface PagoService {

    Pago buscarPorId(Integer id);

    Pago guardar(Pago t);

    void borrar(Integer id);

    List<Pago> buscarTodas();
}
