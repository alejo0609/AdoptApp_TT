package com.pruebas.controller;

import com.pruebas.model.TipoDocumentosModel;
import com.pruebas.service.TipoDocumentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipo_documentos")
public class TipoDocumentosController {

    @Autowired
    private TipoDocumentosService tipoDocumentosService;

    @GetMapping
    public List<TipoDocumentosModel> obtenerTodos() {
        return tipoDocumentosService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<TipoDocumentosModel> obtenerPorId(@PathVariable int id) {
        return tipoDocumentosService.obtenerPorId(id);
    }

    @PostMapping
    public TipoDocumentosModel guardar(@RequestBody TipoDocumentosModel tipoDocumentos) {
        return tipoDocumentosService.guardar(tipoDocumentos);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return tipoDocumentosService.eliminar(id) ? "Eliminado correctamente" : "No se encontró el ID";
    }
}