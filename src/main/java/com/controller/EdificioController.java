package com.controller;

import com.dto.EdificioDTO;
import com.model.Duenio;
import com.model.Edificio;
import com.model.Inquilino;
import com.model.Reclamo;
import com.model.Unidad;
import com.service.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edificio")
public class EdificioController {
    @Autowired
    private EdificioService edificioService;

    @PostMapping
    public ResponseEntity<Edificio> guardar(@RequestBody EdificioDTO edificio) {
        System.out.println("ENTRE AL CONTROLLER");
        return ResponseEntity.ok(edificioService.guardar(edificio));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Edificio>>  listar() {
        return ResponseEntity.ok(edificioService.listar());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/unidadeslibres/{id}")
    public ResponseEntity<List<Unidad>>  listarLibres(@PathVariable Long id) {
        return ResponseEntity.ok(edificioService.listarLibres(id));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/duenios/{id}")
    public ResponseEntity<List<Duenio>>  listarDuenios(@PathVariable Long id) {
        return ResponseEntity.ok(edificioService.listarDuenios(id));
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/inquilinos/{id}")
    public ResponseEntity<List<Inquilino>> listarInquilinos(@PathVariable Long id) {
        return ResponseEntity.ok(edificioService.listarInquilinos(id));
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/reclamos/{id}")
    public ResponseEntity<List<Reclamo>> listarReclamos(@PathVariable Long id) {
        return ResponseEntity.ok(edificioService.listarReclamos(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Edificio> buscar(@PathVariable Long id) {
        Edificio edificio = edificioService.buscar(id);
        return ResponseEntity.ok(edificio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        edificioService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Edificio> modificar(@PathVariable( name = "id") Long id, @RequestBody EdificioDTO edificio) {
        return ResponseEntity.ok(edificioService.modificar(id, edificio));
    }
}