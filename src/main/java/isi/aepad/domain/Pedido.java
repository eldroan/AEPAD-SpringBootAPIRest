package isi.aepad.domain;

import java.util.Date;
import java.util.List;

public class Pedido {
    private Integer id;
    private Double numeroDePedido;
    private Date fecha;
    private Cliente cliente;
    private List<DetallePedido> detallePedidos;
}
