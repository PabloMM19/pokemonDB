package com.pokemondb.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pokemondb.pokemon.entity.EntrenadorEntity;

public interface EntrenadorRepository extends JpaRepository<EntrenadorEntity, Long>{
    
}
