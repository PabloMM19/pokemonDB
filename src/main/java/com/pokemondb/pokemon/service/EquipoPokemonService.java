package com.pokemondb.pokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pokemondb.pokemon.entity.EquipoPokemonEntity;
import com.pokemondb.pokemon.exception.ResourceNotFoundException;
import com.pokemondb.pokemon.repository.EquipoPokemonRepository;

@Service
public class EquipoPokemonService {
    @Autowired
    EquipoPokemonRepository oEquipoPokemonRepository;

    public EquipoPokemonEntity get(Long id) {
        return oEquipoPokemonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EquipoPokemon no encontrado"));

    }

    public Long create(EquipoPokemonEntity oEquipoPokemonEntity) {
        return oEquipoPokemonRepository.save(oEquipoPokemonEntity).getId();
    }

    public EquipoPokemonEntity update(EquipoPokemonEntity oEquipoPokemonEntity) {
        return oEquipoPokemonRepository.save(oEquipoPokemonEntity);
    }

    public Long delete(Long id) {
        EquipoPokemonEntity oEquipoPokemonEntity = oEquipoPokemonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EquipoPokemon no encontrado"));
        oEquipoPokemonRepository.delete(oEquipoPokemonEntity);
        return id;
    }

    public Page<EquipoPokemonEntity> getPage(Pageable pageable) {
        return oEquipoPokemonRepository.findAll(pageable);
    }
}
