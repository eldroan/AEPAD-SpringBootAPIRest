package isi.aepad.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;


public class Cliente {


    private Integer id;
    private String nombre;
    private Localidad localidad;
    private List<Pedido> pedidosRealizados;
    private MedioDePago medioDePago;
    private List<Pago> pagosRealizados;
    private Double puntosAcumulados;

}
