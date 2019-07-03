package isi.aepad.service.impl;

import isi.aepad.domain.*;
import isi.aepad.repository.ClienteRepository;
import isi.aepad.repository.PedidoRepository;
import isi.aepad.repository.ProductoRepository;
import isi.aepad.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SuppressWarnings("Duplicates")
@Service
public class PedidoServiceDefault implements PedidoService {

    @Autowired
    private PedidoRepository repository;

    //Estos metodos me los traigo para que sea mas facil crear un pedido
    @Autowired
    private ProductoRepository productorepository;
    @Autowired
    private ClienteRepository clienterepository;



    @Override
    public Pedido buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public Pedido guardar(Pedido t) {

        Random r = new Random();
        List<Cliente> clientes = clienterepository.findAll();
        Cliente clienteRandom = clientes.get(r.nextInt(clientes.size()));

        int cantidadDeProductos = r.nextInt(7) + 4; //cantidad aleatorea entre 4 y 10;

        List<Producto> productos = productorepository.findAll();
        List<Producto> productoRandom = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();

        int counter = 0;

        while(counter < cantidadDeProductos){
            int currentInt = r.nextInt(productos.size());

            if(numberList.contains(currentInt) == false){
                numberList.add(currentInt);
                productoRandom.add(productos.get(currentInt));
                counter++;
            }
        }

        List<DetallePedido> detallesPedidosRandom = new ArrayList<>();
        for(int i = 0; i<cantidadDeProductos;i++){
            DetallePedido dp = new DetallePedido();
            dp.setPedido(t);
            dp.setProducto(productoRandom.get(i));
            dp.setCantidad(r.nextInt(10));
            dp.setPrecio(productoRandom.get(i).getPrecio());
            dp.setTotal(dp.getPrecio()*dp.getCantidad());

            detallesPedidosRandom.add(dp);
        }

        t.setDetallePedidos(detallesPedidosRandom);
        t.setCliente(clienteRandom);
        t.setFecha(new Date());

        return repository.save(t); //Aca estoy confiando que spring boot es piola y se va a dar cuenta que los detalles pedidos son nuevos
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Pedido> buscarTodas() {
        return repository.findAll();
    }
}
