package org.jsanmarco.springframework.boot.services;

import org.jsanmarco.springframework.boot.models.Producto;
import org.jsanmarco.springframework.boot.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
@Qualifier("productoService")
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public void guardar() {
        Producto producto1 = new Producto();
        producto1.setNombre("Moto Honda XR 250");
        producto1.setPrecio(49000.0);
        productoRepository.save(producto1);
    }

    @Override
    public Iterable<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public void eliminarPorId(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Optional<Producto> buscarPorId(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public void actualizarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public Boolean actualizarPrecioProducto(Integer idProducto, Double precioActualizado) {
        return null;
    }


}