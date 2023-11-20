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

import com.pokemondb.pokemon.entity.PokemonEntity;
import com.pokemondb.pokemon.service.PokemonService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/pokemon")
public class PokemonApi {
    @Autowired
    PokemonService oPokemonService;
    
    @GetMapping("/{id}")
    public ResponseEntity<PokemonEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oPokemonService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody PokemonEntity oPokemonEntity) {
        return ResponseEntity.ok(oPokemonService.create(oPokemonEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PokemonEntity> update(@RequestBody PokemonEntity oPokemonEntity) {
        return ResponseEntity.ok(oPokemonService.update(oPokemonEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oPokemonService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<PokemonEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oPokemonService.getPage(oPageable));
    }

    @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(oPokemonService.populate(amount));
    }
}
