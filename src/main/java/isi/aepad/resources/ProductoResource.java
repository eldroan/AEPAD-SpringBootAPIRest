package isi.aepad.resources;

import isi.aepad.domain.Producto;
import isi.aepad.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoResource {

    @Autowired
    private ProductoService service;

    @GetMapping("producto")
    public ResponseEntity<List<Producto>> buscar(){
        return new ResponseEntity<>(this.service.buscarTodas(), HttpStatus.OK);
    }

    @GetMapping("producto/{id}")
    public ResponseEntity<Producto> buscar(@RequestParam(value = "id") Integer idParam){
        return new ResponseEntity<>(this.service.buscarPorId(idParam), HttpStatus.OK);
    }

    @PostMapping("producto")
    public ResponseEntity<Producto> crear(@RequestBody Producto body, UriComponentsBuilder builder){
        Producto creado = this.service.guardar(body);

        if(creado == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/producto/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<>(creado, headers, HttpStatus.CREATED);
    }

    @PutMapping("producto")
    public ResponseEntity<Producto> actualizar(@RequestBody Producto body, UriComponentsBuilder builder){
        return new ResponseEntity<>(this.service.guardar(body), HttpStatus.OK);
    }

    @DeleteMapping("producto/{id}")
    public ResponseEntity<Void> borrar(@RequestParam(value = "id") Integer idParam){
        this.service.borrar(idParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
