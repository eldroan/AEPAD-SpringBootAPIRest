package isi.aepad.service;

import isi.aepad.domain.Localidad;

import java.util.List;

public interface LocalidadService {

    Localidad buscarPorId(Integer id);

    Localidad guardar(Localidad t);

    void borrar(Integer id);

    List<Localidad> buscarTodas();
}
