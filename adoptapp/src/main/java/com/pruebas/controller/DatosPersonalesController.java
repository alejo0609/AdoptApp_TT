 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.controller;

import com.pruebas.model.DatosPersonalesModel;
import com.pruebas.service.DatosPersonalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/datos_personales")
public class DatosPersonalesController {

    @Autowired
    private DatosPersonalesService datosPersonalesService;

    @GetMapping()
    public List<DatosPersonalesModel> obtenerTodos() {
        return datosPersonalesService.obtenerTodos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable int id) {
        Optional<DatosPersonalesModel> usuario = datosPersonalesService.obtenerPorId(id);
        return usuario.isPresent() 
            ? ResponseEntity.ok(usuario) 
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\": \"Usuario no encontrado\"}");
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<DatosPersonalesModel> obtenerPorDni(@PathVariable Long dni) {
        Optional<DatosPersonalesModel> persona = datosPersonalesService.obtenerPorDni(dni);
        return persona.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
 }


    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody DatosPersonalesModel usuario) {
        DatosPersonalesModel nuevoUsuario = datosPersonalesService.guardar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody DatosPersonalesModel usuario) {
        Optional<DatosPersonalesModel> usuarioEncontrado = datosPersonalesService.autenticarUsuario(usuario.getEmail(), usuario.getPassword());

        if (usuarioEncontrado.isPresent()) {
            return ResponseEntity.ok("{\"mensaje\": \"Inicio de sesión exitoso\"}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"mensaje\": \"Credenciales incorrectas\"}");
        }
    }




    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return datosPersonalesService.eliminar(id) ? "Eliminado correctamente" : "No se encontró el ID";
    }
    @DeleteMapping("/dni/{dni}")
    public String eliminarPorDni(@PathVariable long dni) {
        return datosPersonalesService.eliminarPorDni(dni) ? "Eliminado correctamente" : "No se encontró el ID";
    } 
}