 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.controller;

import com.pruebas.model.TipoUsuarioModel;
import com.pruebas.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipo_usuarios")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipo_usuarioService;

    @GetMapping
    public List<TipoUsuarioModel> obtenerTodos() {
        return tipo_usuarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<TipoUsuarioModel> obtenerPorId(@PathVariable int id) {
        return tipo_usuarioService.obtenerPorId(id);
    }

    @PostMapping
    public TipoUsuarioModel guardar(@RequestBody TipoUsuarioModel tipo_usuario) {
        return tipo_usuarioService.guardar(tipo_usuario);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return tipo_usuarioService.eliminar(id) ? "Eliminado correctamente" : "No se encontró el ID";
    }
}