package isi.aepad.service.impl;

import isi.aepad.domain.Cliente;
import isi.aepad.domain.DetalleOrdenCompra;
import isi.aepad.domain.OrdenCompra;
import isi.aepad.domain.Producto;
import isi.aepad.repository.ClienteRepository;
import isi.aepad.repository.OrdenCompraRepository;
import isi.aepad.repository.ProductoRepository;
import isi.aepad.service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SuppressWarnings("Duplicates")
@Service
public class OrdenCompraServiceDefault implements OrdenCompraService {

    @Autowired
    private OrdenCompraRepository repository;

    //Estos metodos me los traigo para que sea mas facil crear un pedido
    @Autowired
    private ProductoRepository productorepository;
    @Autowired
    private ClienteRepository clienterepository;
    @Override
    public OrdenCompra buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public OrdenCompra guardar(OrdenCompra t) {
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
        List<DetalleOrdenCompra> detalleOrdenComprasRandom = new ArrayList<>();

        for(int i = 0; i< cantidadDeProductos; i++){
            DetalleOrdenCompra doc = new DetalleOrdenCompra();
            doc.setProducto(productoRandom.get(i));
            doc.setCantidad(r.nextInt(10));
            doc.setPrecio(productoRandom.get(i).getPrecio());
            doc.setOrdenDeCompra(t);
            doc.setTotal(doc.getPrecio()*doc.getCantidad());

            detalleOrdenComprasRandom.add(doc);
        }

        t.setCliente(clienteRandom);
        t.setFecha(new Date());
        t.setNumeroDeCompra((double)r.nextInt(1000000));
        t.setDetalleOrdenCompras(detalleOrdenComprasRandom);

        return repository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<OrdenCompra> buscarTodas() {
        return repository.findAll();
    }
}
