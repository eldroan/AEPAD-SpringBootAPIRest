package isi.aepad.resources;

import isi.aepad.domain.Usuario;
import isi.aepad.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @GetMapping("usuario")
    public ResponseEntity<List<Usuario>> buscar(){
        return new ResponseEntity<>(this.service.buscarTodas(), HttpStatus.OK);
    }

    @GetMapping("usuario/{id}")
    public ResponseEntity<Usuario> buscar(@RequestParam(value = "id") Integer idParam){
        return new ResponseEntity<>(this.service.buscarPorId(idParam), HttpStatus.OK);
    }

    @PostMapping("usuario")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario body, UriComponentsBuilder builder){
        Usuario creado = this.service.guardar(body);

        if(creado == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/cliente/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<>(creado, headers, HttpStatus.CREATED);
    }

    @PutMapping("usuario")
    public ResponseEntity<Usuario> actualizar(@RequestBody Usuario body, UriComponentsBuilder builder){
        return new ResponseEntity<>(this.service.guardar(body), HttpStatus.OK);
    }

    @DeleteMapping("usuario/{id}")
    public ResponseEntity<Void> borrar(@RequestParam(value = "id") Integer idParam){
        this.service.borrar(idParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
