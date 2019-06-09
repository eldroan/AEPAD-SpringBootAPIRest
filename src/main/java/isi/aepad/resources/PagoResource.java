package isi.aepad.resources;

import isi.aepad.domain.Pago;
import isi.aepad.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/pago")
public class PagoResource {

    @Autowired
    private PagoService service;

    @GetMapping("pago")
    public ResponseEntity<List<Pago>> buscar(){
        return new ResponseEntity<>(this.service.buscarTodas(), HttpStatus.OK);
    }

    @GetMapping("pago/{id}")
    public ResponseEntity<Pago> buscar(@RequestParam(value = "id") Integer idParam){
        return new ResponseEntity<>(this.service.buscarPorId(idParam), HttpStatus.OK);
    }

    @PostMapping("pago")
    public ResponseEntity<Pago> crear(@RequestBody Pago body, UriComponentsBuilder builder){
        Pago creado = this.service.guardar(body);

        if(creado == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/pago/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<>(creado, headers, HttpStatus.CREATED);
    }

    @PutMapping("pago")
    public ResponseEntity<Pago> actualizar(@RequestBody Pago body, UriComponentsBuilder builder){
        return new ResponseEntity<>(this.service.guardar(body), HttpStatus.OK);
    }

    @DeleteMapping("pago/{id}")
    public ResponseEntity<Void> borrar(@RequestParam(value = "id") Integer idParam){
        this.service.borrar(idParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
