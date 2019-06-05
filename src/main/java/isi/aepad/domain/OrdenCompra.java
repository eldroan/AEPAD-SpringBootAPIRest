package isi.aepad.domain;

import java.util.Date;
import java.util.List;

public class OrdenCompra {
    private Integer id;
    private Double numeroDeCompra;
    private Date fecha;
    private Cliente cliente;
    private List<DetalleOrdenCompra> detalleOrdenCompras;

}
