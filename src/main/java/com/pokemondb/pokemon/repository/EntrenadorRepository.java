package com.pokemondb.pokemon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pokemondb.pokemon.entity.EntrenadorEntity;

public interface EntrenadorRepository extends JpaRepository<EntrenadorEntity, Long>{
    Optional <EntrenadorEntity> findByUsernameAndPassword(String username, String password);
    Optional<EntrenadorEntity> findByUsername(String username);
}
