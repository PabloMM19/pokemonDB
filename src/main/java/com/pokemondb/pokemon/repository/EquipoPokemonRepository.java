package com.pokemondb.pokemon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokemondb.pokemon.entity.EquipoPokemonEntity;

public interface EquipoPokemonRepository extends JpaRepository<EquipoPokemonEntity, Long> {
    List<EquipoPokemonEntity> findByEquipo_Id(Long equipoId);
}