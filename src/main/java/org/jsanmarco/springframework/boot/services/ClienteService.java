package org.jsanmarco.springframework.boot.services;

import org.jsanmarco.springframework.boot.models.Cliente;

import java.util.Optional;


public interface ClienteService {
    void guardar();
    Iterable<Cliente> listar();

    void eliminarPorId(Integer id);

    Optional<Cliente> buscarPorId(Integer id);

    Boolean actualizarCliente(Cliente cliente);

    void guardar(Cliente cliente);

}