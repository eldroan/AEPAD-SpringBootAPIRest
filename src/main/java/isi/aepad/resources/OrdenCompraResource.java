package isi.aepad.resources;

import isi.aepad.domain.OrdenCompra;
import isi.aepad.service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/ordencompra")
public class OrdenCompraResource {

    @Autowired
    private OrdenCompraService service;

    @GetMapping("ordencompra")
    public ResponseEntity<List<OrdenCompra>> buscar(){
        return new ResponseEntity<>(this.service.buscarTodas(), HttpStatus.OK);
    }

    @GetMapping("ordencompra/{id}")
    public ResponseEntity<OrdenCompra> buscar(@RequestParam(value = "id") Integer idParam){
        return new ResponseEntity<>(this.service.buscarPorId(idParam), HttpStatus.OK);
    }

    @PostMapping("ordencompra")
    public ResponseEntity<OrdenCompra> crear(@RequestBody OrdenCompra body, UriComponentsBuilder builder){
        OrdenCompra creado = this.service.guardar(body);

        if(creado == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/ordencompra/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<>(creado, headers, HttpStatus.CREATED);
    }

    @PutMapping("ordencompra")
    public ResponseEntity<OrdenCompra> actualizar(@RequestBody OrdenCompra body, UriComponentsBuilder builder){
        return new ResponseEntity<>(this.service.guardar(body), HttpStatus.OK);
    }

    @DeleteMapping("ordencompra/{id}")
    public ResponseEntity<Void> borrar(@RequestParam(value = "id") Integer idParam){
        this.service.borrar(idParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
