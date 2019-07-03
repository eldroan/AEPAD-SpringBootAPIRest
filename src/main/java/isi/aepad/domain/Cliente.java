package isi.aepad.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Integer id;

    private String nombre;

    @OneToOne
    private Localidad localidad;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Pedido> pedidosRealizados;

    @OneToOne
    private MedioDePago medioDePago;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Pago> pagosRealizados;

    private Double puntosAcumulados;

    //--- Getters & Setters ---//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public List<Pedido> getPedidosRealizados() {
        return pedidosRealizados;
    }

    public void setPedidosRealizados(List<Pedido> pedidosRealizados) {
        this.pedidosRealizados = pedidosRealizados;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }

    public List<Pago> getPagosRealizados() {
        return pagosRealizados;
    }

    public void setPagosRealizados(List<Pago> pagosRealizados) {
        this.pagosRealizados = pagosRealizados;
    }

    public Double getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(Double puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }


}
