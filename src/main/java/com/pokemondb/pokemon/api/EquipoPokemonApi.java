package com.pokemondb.pokemon.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemondb.pokemon.entity.EquipoEntity;
import com.pokemondb.pokemon.entity.EquipoPokemonEntity;
import com.pokemondb.pokemon.entity.PokemonEntity;
import com.pokemondb.pokemon.exception.ResourceNotFoundException;
import com.pokemondb.pokemon.repository.EquipoRepository;
import com.pokemondb.pokemon.repository.PokemonRepository;
import com.pokemondb.pokemon.service.EquipoPokemonService;

@RestController
@RequestMapping("/equipoPokemon")
public class EquipoPokemonApi {
    @Autowired
    EquipoPokemonService oEquipoPokemonService;

    @Autowired
    PokemonRepository pokemonRepository;
    
    @Autowired
    EquipoRepository equipoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<EquipoPokemonEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oEquipoPokemonService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody Map<String, Long> request) {
        Long equipoId = request.get("equipo_id");
        Long pokemonId = request.get("pokemon_id");
        
        EquipoEntity equipo = equipoRepository.findById(equipoId)
            .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado"));

        PokemonEntity pokemon = pokemonRepository.findById(pokemonId)
            .orElseThrow(() -> new ResourceNotFoundException("Pokemon no encontrado"));

        EquipoPokemonEntity equipoPokemon = new EquipoPokemonEntity(pokemon, equipo);
        
        return ResponseEntity.ok(oEquipoPokemonService.create(equipoPokemon));
    }

    @PutMapping("")
    public ResponseEntity<EquipoPokemonEntity> update(EquipoPokemonEntity oEquipoPokemonEntity) {
        return ResponseEntity.ok(oEquipoPokemonService.update(oEquipoPokemonEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oEquipoPokemonService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<EquipoPokemonEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oEquipoPokemonService.getPage(oPageable));
    }
}
