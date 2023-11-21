package com.pokemondb.pokemon.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemondb.pokemon.entity.EntrenadorEntity;
import com.pokemondb.pokemon.service.EntrenadorService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/entrenador")
public class EntrenadorApi {

    @Autowired
    EntrenadorService oEntrenadorService;

    @GetMapping("/{id}")
    public ResponseEntity<EntrenadorEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oEntrenadorService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody EntrenadorEntity oEntrenadorEntity) {
        return ResponseEntity.ok(oEntrenadorService.create(oEntrenadorEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntrenadorEntity> update(@RequestBody EntrenadorEntity oEntrenadorEntity) {
        return ResponseEntity.ok(oEntrenadorService.update(oEntrenadorEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oEntrenadorService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<EntrenadorEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oEntrenadorService.getPage(oPageable));
    }

    @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(oEntrenadorService.populate(amount));
    }

    @DeleteMapping("/empty")
    public ResponseEntity<Long> empty() {
        return ResponseEntity.ok(oEntrenadorService.empty());
    }

    /*get username by id */
    @GetMapping("/username/{id}")
    public ResponseEntity<String> getUsernameById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oEntrenadorService.getUsernameById(id));
    }

    /* jwt validation */
    @GetMapping("/jwt/{token}")
    public ResponseEntity<String> validateJWT(@PathVariable("token") String token) {
        return ResponseEntity.ok(oEntrenadorService.validateJWT(token));
    }
}
