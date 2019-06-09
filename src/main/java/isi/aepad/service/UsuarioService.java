package isi.aepad.service;

import isi.aepad.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario buscarPorId(Integer id);

    Usuario guardar(Usuario t);

    void borrar(Integer id);

    List<Usuario> buscarTodas();
}
