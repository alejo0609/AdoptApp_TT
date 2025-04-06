 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.controller;

import com.pruebas.model.TipoVacunaModel;
import com.pruebas.service.TipoVacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipo_vacunas")
public class TipoVacunaController {

    @Autowired
    private TipoVacunaService tipoVacunaService;

    @GetMapping
    public List<TipoVacunaModel> obtenerTodos() {
        return tipoVacunaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<TipoVacunaModel> obtenerPorId(@PathVariable int id) {
        return tipoVacunaService.obtenerPorId(id);
    }

    @PostMapping
    public TipoVacunaModel guardar(@RequestBody TipoVacunaModel tipoVacuna) {
        return tipoVacunaService.guardar(tipoVacuna);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return tipoVacunaService.eliminar(id) ? "Eliminado correctamente" : "No se encontró el ID";
    }
}