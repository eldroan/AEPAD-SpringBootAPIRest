package isi.aepad.service;

import isi.aepad.domain.MedioDePago;

import java.util.List;

public interface MedioDePagoService {

    MedioDePago buscarPorId(Integer id);

    MedioDePago guardar(MedioDePago t);

    void borrar(Integer id);

    List<MedioDePago> buscarTodas();
}
