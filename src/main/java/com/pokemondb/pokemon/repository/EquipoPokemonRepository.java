package com.pokemondb.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokemondb.pokemon.entity.EquipoPokemonEntity;

public interface EquipoPokemonRepository extends JpaRepository<EquipoPokemonEntity, Long> {
    
}
