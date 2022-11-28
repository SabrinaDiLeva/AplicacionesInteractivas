package com.controller;

import com.dto.ImagenDTO;
import com.model.Imagen;
import com.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagen")
public class ImagenController {
    @Autowired
    private ImagenService ImagenService;

    @PostMapping
    public ResponseEntity<Imagen> guardar(@RequestBody ImagenDTO Imagen) {
        return ResponseEntity.ok(ImagenService.guardar(Imagen));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Imagen>>  listar() {
        return ResponseEntity.ok(ImagenService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagen> buscar(@PathVariable Long id) {
        Imagen Imagen = ImagenService.buscar(id);
        return ResponseEntity.ok(Imagen);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        ImagenService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imagen> modificar(@PathVariable( name = "id") Long id, @RequestBody ImagenDTO Imagen) {
        return ResponseEntity.ok(ImagenService.modificar(id, Imagen));
    }
}
