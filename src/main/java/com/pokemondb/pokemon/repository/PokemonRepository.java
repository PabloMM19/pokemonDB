package com.pokemondb.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokemondb.pokemon.entity.PokemonEntity;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Long>{
    
}
