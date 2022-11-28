package com.controller;

import com.dto.ReclamoDTO;
import com.model.Reclamo;
import com.service.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamo")
public class ReclamoController {
    @Autowired
    private ReclamoService reclamoService;

    @PostMapping
    public ResponseEntity<Reclamo> guardar(@RequestBody ReclamoDTO reclamo) {
        return ResponseEntity.ok(reclamoService.guardar(reclamo));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Reclamo>>  listar() {
        return ResponseEntity.ok(reclamoService.listar());
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/unidad/{id}")
    public ResponseEntity<List<Reclamo>>  listarPorCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(reclamoService.listarPorIdUnidad(id));
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/persona/{id}")
    public ResponseEntity<List<Reclamo>>  listarPorPersona(@PathVariable Long id) {
        return ResponseEntity.ok(reclamoService.listarPorIdPersona(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reclamo> buscar(@PathVariable Long id) {
        Reclamo reclamo = reclamoService.buscar(id);
        return ResponseEntity.ok(reclamo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        reclamoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reclamo> modificar(@PathVariable( name = "id") Long id, @RequestBody ReclamoDTO reclamo) {
        return ResponseEntity.ok(reclamoService.modificar(id, reclamo));
    }
}
