package org.jsanmarco.springframework.boot.services;

import org.jsanmarco.springframework.boot.models.Producto;

import java.util.Optional;


public interface ProductoService {
    void guardar();
    Iterable<Producto> listar();

    void eliminarPorId(Integer id);

    Optional<Producto> buscarPorId(Integer id);

    Boolean actualizarProducto(Producto producto);

    Boolean actualizarPrecioProducto(Integer idProducto, Double precioActualizado);
}