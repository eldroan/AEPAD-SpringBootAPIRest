package isi.aepad.service;

import isi.aepad.domain.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente buscarPorId(Integer id);

    Cliente guardar(Cliente t);

    void borrar(Integer id);

    List<Cliente> buscarTodas();
}
