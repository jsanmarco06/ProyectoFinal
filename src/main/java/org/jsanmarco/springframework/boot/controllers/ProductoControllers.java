package org.jsanmarco.springframework.boot.controllers;

import org.jsanmarco.springframework.boot.models.Producto;
import org.jsanmarco.springframework.boot.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductoControllers {

    //Autowired esta
    @Autowired
    @Qualifier("productoService")
    private ProductoService productoService;


    @RequestMapping("/addProducto")
    //Vamos a agregar la notacion de PathVariable que nos permitira tomar desde la url del navegador un valor.
    public ResponseEntity<String> addProducto(){

        productoService.guardar();

        return new ResponseEntity<>("guardado", HttpStatus.OK);
    }

    @GetMapping(value = "/agregar")
    public String agregarProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "agregar_producto";
    }

    @RequestMapping(value="/listarProductos", method= RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Productos");
        model.addAttribute("productos", productoService.listar());
        return "productos/listarProductos";
    }

    /*Agregar un producto Nuevo*/

    /*Metodo que se ejecuta al presionar el boton Editar para un Producto de la lista*/
    @GetMapping(value="/editarProductos/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model){
        model.addAttribute("producto",productoService.buscarPorId(id).orElse(null));
        return "productos/editar_producto";
    }


    /*import javax.validation.Valid;*/
    @PostMapping(value = "/editarProductos/{id}")
    public String actualizarProducto(@ModelAttribute Producto producto, BindingResult bindingResult, RedirectAttributes redirectAttrs) {

        productoService.actualizarProducto(producto);
        redirectAttrs
                .addFlashAttribute("mensaje", "Editado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/listarProductos";
    }


    /*Eliminar Producto byID*/
    @RequestMapping(value="/eliminarProductos/{id}", method = RequestMethod.GET)
    public String eliminar(@PathVariable(value = "id") int id){
        if(id > 0){
            productoService.eliminarPorId(id);
        }
        return "redirect:/listarProductos";
    }


}