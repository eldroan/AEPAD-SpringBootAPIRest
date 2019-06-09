package isi.aepad.resources;

import isi.aepad.domain.DetallePedido;
import isi.aepad.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/detallepedido")
public class DetallePedidoResource {

    @Autowired
    private DetallePedidoService service;

    @GetMapping("detallepedido")
    public ResponseEntity<List<DetallePedido>> buscar(){
        return new ResponseEntity<>(this.service.buscarTodas(), HttpStatus.OK);
    }

    @GetMapping("detallepedido/{id}")
    public ResponseEntity<DetallePedido> buscar(@RequestParam(value = "id") Integer idParam){
        return new ResponseEntity<>(this.service.buscarPorId(idParam), HttpStatus.OK);
    }

    @PostMapping("detallepedido")
    public ResponseEntity<DetallePedido> crear(@RequestBody DetallePedido body, UriComponentsBuilder builder){
        DetallePedido creado = this.service.guardar(body);

        if(creado == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/detallepedido/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<>(creado, headers, HttpStatus.CREATED);
    }

    @PutMapping("detallepedido")
    public ResponseEntity<DetallePedido> actualizar(@RequestBody DetallePedido body, UriComponentsBuilder builder){
        DetallePedido actualizar = this.service.guardar(body);
        return new ResponseEntity<>(actualizar, HttpStatus.OK);
    }

    @DeleteMapping("detallepedido/{id}")
    public ResponseEntity<Void> borrar(@RequestParam(value = "id") Integer idParam){
        this.service.borrar(idParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
