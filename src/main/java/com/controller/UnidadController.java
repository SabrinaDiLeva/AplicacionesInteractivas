package com.controller;

import com.dto.UnidadDTO;
import com.model.Unidad;
import com.model.Duenio;
import com.model.Inquilino;
import com.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

import java.util.List;

@RestController
@RequestMapping("/unidad")
public class UnidadController {
    @Autowired
    private UnidadService unidadService;

    @PostMapping
    public ResponseEntity<Unidad> guardar(@RequestBody UnidadDTO unidad) {
        return ResponseEntity.ok(unidadService.guardar(unidad));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Unidad>>  listar() {
        return ResponseEntity.ok(unidadService.listar());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/edificio/{id}")
    public ResponseEntity<List<Unidad>>  listarPorEdificio(@PathVariable Long id) {
        return ResponseEntity.ok(unidadService.listarPorIdEdificio(id));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}/duenios")
    public ResponseEntity<Set<Duenio>>  listarDuenios(@PathVariable Long id) {
        return ResponseEntity.ok(unidadService.listarDuenios(id));
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}/inquilinos")
    public ResponseEntity<Set<Inquilino>>  listarInquilinos(@PathVariable Long id) {
        return ResponseEntity.ok(unidadService.listarInquilinos(id));
    }

    @PutMapping("/{id}/transferir/{duenio}")
    public ResponseEntity<Void>  transferir(@PathVariable Long id, @PathVariable Long duenio) {
        unidadService.transferir(id, duenio);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("/{id}/agregarduenio/{duenio}")
    public ResponseEntity<Void>  agregarDuenio(@PathVariable Long id, @PathVariable Long duenio) {
        unidadService.agregarDuenio(id, duenio);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}/alquilar/{inquilino}")
    public ResponseEntity<Void>  alquilar(@PathVariable Long id, @PathVariable Long inquilino) {
        unidadService.alquilar(id, inquilino);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}/liberar")
    public ResponseEntity<Void>  liberar(@PathVariable Long id) {
        unidadService.liberar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Unidad> buscar(@PathVariable Long id) {
        Unidad unidad = unidadService.buscar(id);
        return ResponseEntity.ok(unidad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        unidadService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidad> modificar(@PathVariable( name = "id") Long id, @RequestBody UnidadDTO unidad) {
        return ResponseEntity.ok(unidadService.modificar(id, unidad));
    }
}