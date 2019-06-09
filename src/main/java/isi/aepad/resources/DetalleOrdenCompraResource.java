package isi.aepad.resources;

import isi.aepad.domain.DetalleOrdenCompra;
import isi.aepad.service.DetalleOrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/detalleordencompra")
public class DetalleOrdenCompraResource {

    @Autowired
    private DetalleOrdenCompraService service;

    @GetMapping("detalleordencompra")
    public ResponseEntity<List<DetalleOrdenCompra>> buscar(){
        return new ResponseEntity<List<DetalleOrdenCompra>>(this.service.buscarTodas(), HttpStatus.OK);
    }

    @GetMapping("detalleordencompra/{id}")
    public ResponseEntity<DetalleOrdenCompra> buscar(@RequestParam(value = "id") Integer idParam){
        return new ResponseEntity<DetalleOrdenCompra>(this.service.buscarPorId(idParam),HttpStatus.OK);
    }

    @PostMapping("detalleordencompra")
    public ResponseEntity<DetalleOrdenCompra> crear(@RequestBody DetalleOrdenCompra body, UriComponentsBuilder builder){
        DetalleOrdenCompra creado = this.service.guardar(body);

        if(creado == null){
            return new ResponseEntity<DetalleOrdenCompra>(HttpStatus.NO_CONTENT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/detalleordencompra/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<DetalleOrdenCompra>(creado,headers,HttpStatus.CREATED);
    }

    @PutMapping("detalleordencompra")
    public ResponseEntity<DetalleOrdenCompra> actualizar(@RequestBody DetalleOrdenCompra body, UriComponentsBuilder builder){
        DetalleOrdenCompra actualizar = this.service.guardar(body);
        return new ResponseEntity<DetalleOrdenCompra>(actualizar, HttpStatus.OK);
    }

    @DeleteMapping("detalleordencompra/{id}")
    public ResponseEntity<Void> borrar(@RequestParam(value = "id") Integer idParam){
        this.service.borrar(idParam);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }



}
