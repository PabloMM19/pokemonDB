package com.pokemondb.pokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pokemondb.pokemon.entity.PokemonEntity;
import com.pokemondb.pokemon.exception.ResourceNotFoundException;
import com.pokemondb.pokemon.repository.PokemonRepository;

public class PokemonService {

    @Autowired
    PokemonRepository oPokemonRepository;

    public PokemonEntity get(Long id) {
        return oPokemonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pokemon no encontrado"));

    }

    public Long create(PokemonEntity oPokemonEntity) {
        return oPokemonRepository.save(oPokemonEntity).getId();
    }

    public PokemonEntity update(PokemonEntity oPokemonEntity) {
        return oPokemonRepository.save(oPokemonEntity);
    }

    public Long delete(Long id) {
        PokemonEntity oPokemonEntity = oPokemonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entrenador no encontrado"));
        oPokemonRepository.delete(oPokemonEntity);
        return id;
    }

    public Page<PokemonEntity> getPage(Pageable pageable) {
        return oPokemonRepository.findAll(pageable);
    }

    public Long populate(Integer amount) {
        for (int i = 0; i < amount; i++) {
            PokemonEntity oPokemonEntity = new PokemonEntity();
            oPokemonEntity.setNombre("Pokemon " + i);
            oPokemonEntity.setTipo1("Normal");
            oPokemonEntity.setTipo2("Fuego");
            oPokemonEntity.setHabilidad("Mar llamas");
            oPokemonEntity.setAtaque(50);
            oPokemonEntity.setDefensa(50);
            oPokemonEntity.setVelocidad(50);
            oPokemonEntity.setSalud(50);
            oPokemonEntity.setAtaque_Especial(50);
            oPokemonEntity.setDefensa_Especial(50);
            oPokemonEntity.setAtaque1("Placaje");
            oPokemonEntity.setAtaque2("Lanzallamas");
            oPokemonEntity.setAtaque3("Giro Fuego");
            oPokemonEntity.setAtaque4("Llamarada");
            oPokemonEntity.setNivel(50);
            oPokemonEntity.setObjeto("Vidasfera");
            oPokemonEntity.setGeneracion(1);
            oPokemonEntity.setNaturaleza("Alegre");
            oPokemonRepository.save(oPokemonEntity);
        }
        return oPokemonRepository.count();
    }
    
}
