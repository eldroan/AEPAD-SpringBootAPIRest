package isi.aepad.resources;

import isi.aepad.domain.Pedido;
import isi.aepad.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @GetMapping("pedido")
    public ResponseEntity<List<Pedido>> buscar(){
        return new ResponseEntity<>(this.service.buscarTodas(), HttpStatus.OK);
    }

    @GetMapping("pedido/{id}")
    public ResponseEntity<Pedido> buscar(@RequestParam(value = "id") Integer idParam){
        return new ResponseEntity<>(this.service.buscarPorId(idParam), HttpStatus.OK);
    }

    @PostMapping("pedido")
    public ResponseEntity<Pedido> crear(@RequestBody Pedido body, UriComponentsBuilder builder){
        Pedido creado = this.service.guardar(body);

        if(creado == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/pedido/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<>(creado, headers, HttpStatus.CREATED);
    }

    @PutMapping("pedido")
    public ResponseEntity<Pedido> actualizar(@RequestBody Pedido body, UriComponentsBuilder builder){
        return new ResponseEntity<>(this.service.guardar(body), HttpStatus.OK);
    }

    @DeleteMapping("pedido/{id}")
    public ResponseEntity<Void> borrar(@RequestParam(value = "id") Integer idParam){
        this.service.borrar(idParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
