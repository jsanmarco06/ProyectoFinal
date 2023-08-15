package org.jsanmarco.springframework.boot.repositories;

import org.jsanmarco.springframework.boot.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente,Integer> {


}