package isi.aepad.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class OrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Integer id;

    private Double numeroDeCompra;

    private Date fecha;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "ordenDeCompra")
    private List<DetalleOrdenCompra> detalleOrdenCompras;

    //--- Getters & Setters ---//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNumeroDeCompra() {
        return numeroDeCompra;
    }

    public void setNumeroDeCompra(Double numeroDeCompra) {
        this.numeroDeCompra = numeroDeCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleOrdenCompra> getDetalleOrdenCompras() {
        return detalleOrdenCompras;
    }

    public void setDetalleOrdenCompras(List<DetalleOrdenCompra> detalleOrdenCompras) {
        this.detalleOrdenCompras = detalleOrdenCompras;
    }
}
