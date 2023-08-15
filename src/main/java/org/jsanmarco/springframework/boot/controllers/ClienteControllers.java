package org.jsanmarco.springframework.boot.controllers;

import org.jsanmarco.springframework.boot.models.Cliente;
import org.jsanmarco.springframework.boot.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class ClienteControllers {
    //Autowired esta
    @Autowired
    @Qualifier("clienteService")
    private ClienteService clienteService;


    @RequestMapping("/addCliente")
    //Vamos a agregar la notacion de PathVariable que nos permitira tomar desde la url del navegador un valor.
    public ResponseEntity<String> addCliente(){
        clienteService.guardar();
        return new ResponseEntity<>("guardado", HttpStatus.OK);
    }

    @RequestMapping(value = "/agregarCliente")
    public String agregarCliente(Model model){
        model.addAttribute("cliente", new Cliente());
        return "clientes/agregar_cliente";
    }

    @RequestMapping(value = "/guardarCliente", method = RequestMethod.POST)
    public String guardarCliente(Cliente cliente){
        clienteService.guardar(cliente);
        return "clientes/listarClientes";
    }



    @RequestMapping(value="/listarClientes", method= RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Clientes");
        model.addAttribute("clientes", clienteService.listar());
        return "clientes/listarClientes";
    }

}