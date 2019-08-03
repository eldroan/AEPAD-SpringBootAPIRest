package isi.aepad.service.impl;

import isi.aepad.domain.Producto;
import isi.aepad.repository.ProductoRepository;
import isi.aepad.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductoServiceDefault implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    private static boolean modified = true;
    private static  List<Producto> productoCache = null;


    @Override
    public Producto buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public Producto guardar(Producto t) {
        modified = true; //Mi cache ya no sirve
        return repository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Producto> buscarRandom(int amountToReturn) throws Exception {

        List<Producto> productos= null; //me traigo todos

        //Para no pegarle siempre al repository solo lo hago si es la primera vez y no hubieron modificaciones
        if(productoCache == null || modified == true){
            productoCache =repository.findAll(); //me traigo todos
            modified = false;
        }

        productos= productoCache;

        int size= productos.size();

        if(size < amountToReturn){
            //Me estan pidiendo devolver mas valores de los que tengo
            String err = "La cantidad de productos requerida excede la cantidad de productos cargada";
            System.out.println(err);
//            throw new Exception(err);
            amountToReturn = size;
        }

        List<Producto> productoRandom = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        Random rand = new Random();
        int counter = 0;

        while(counter < amountToReturn){
            int currentInt = rand.nextInt(size);

            if(numberList.contains(currentInt) == false){
                numberList.add(currentInt);
                productoRandom.add(productos.get(currentInt));
                counter++;
            }
        }
        return productoRandom;
    }
}
