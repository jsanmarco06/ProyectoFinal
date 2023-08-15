package org.jsanmarco.springframework.boot.repositories;

import org.jsanmarco.springframework.boot.models.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto,Integer> {


}