package com.pruebas.controller;

import com.pruebas.model.DatosPersonalesModel;
import com.pruebas.service.DatosPersonalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/datos_personales")
public class DatosPersonalesController {

    @Autowired
    private DatosPersonalesService datosPersonalesService;

    @GetMapping
    public List<DatosPersonalesModel> obtenerTodos() {
        return datosPersonalesService.obtenerTodos();
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<DatosPersonalesModel> obtenerPorDni(@PathVariable Long dni) {
    Optional<DatosPersonalesModel> persona = datosPersonalesService.obtenerPorDni(dni);
    return persona.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
 }


    @PostMapping
    public DatosPersonalesModel guardar(@RequestBody DatosPersonalesModel datosPersonales) {
        return datosPersonalesService.guardar(datosPersonales);
    }

    @DeleteMapping("/dni/{dni}")
    public String eliminarPorDni(@PathVariable long dni) {
        return datosPersonalesService.eliminarPorDni(dni) ? "Eliminado correctamente" : "No se encontró el ID";
    }
}





