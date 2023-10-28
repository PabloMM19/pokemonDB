package com.pokemondb.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokemondb.pokemon.entity.EquipoEntity;

public interface EquipoRepository extends JpaRepository<EquipoEntity, Long> {
    
}
