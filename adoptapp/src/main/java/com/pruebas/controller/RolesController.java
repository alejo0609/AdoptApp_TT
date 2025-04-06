 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.controller;

import com.pruebas.model.RolesModel;
import com.pruebas.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping
    public List<RolesModel> obtenerTodos() {
        return rolesService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<RolesModel> obtenerPorId(@PathVariable int id) {
        return rolesService.obtenerPorId(id);
    }

    @PostMapping
    public RolesModel guardar(@RequestBody RolesModel roles) {
        return rolesService.guardar(roles);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return rolesService.eliminar(id) ? "Eliminado correctamente" : "No se encontró el ID";
    }
}