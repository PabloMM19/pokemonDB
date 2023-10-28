package com.pokemondb.pokemon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipo_pokemon")
public class EquipoPokemonEntity {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private int equipo_id;
private int pokemon_id;

public EquipoPokemonEntity() {
}

public EquipoPokemonEntity(Long id, int equipo_id, int pokemon_id) {
    this.id = id;
    this.equipo_id = equipo_id;
    this.pokemon_id = pokemon_id;
}

public EquipoPokemonEntity(int equipo_id, int pokemon_id) {
    this.equipo_id = equipo_id;
    this.pokemon_id = pokemon_id;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public int getEquipo_id() {
    return equipo_id;
}

public void setEquipo_id(int equipo_id) {
    this.equipo_id = equipo_id;
}

public int getPokemon_id() {
    return pokemon_id;
}

public void setPokemon_id(int pokemon_id) {
    this.pokemon_id = pokemon_id;
}



}
