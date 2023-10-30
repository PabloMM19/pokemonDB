package com.pokemondb.pokemon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipo_pokemon")
public class EquipoPokemonEntity {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private PokemonEntity pokemon;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private EquipoEntity equipo;

public EquipoPokemonEntity() {

}

public EquipoPokemonEntity(PokemonEntity pokemon, EquipoEntity equipo) {
    this.pokemon = pokemon;
    this.equipo = equipo;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public PokemonEntity getPokemon() {
    return pokemon;
}

public void setPokemon(PokemonEntity pokemon) {
    this.pokemon = pokemon;
}

public EquipoEntity getEquipo() {
    return equipo;
}

public void setEquipo(EquipoEntity equipo) {
    this.equipo = equipo;
}

/*get pokemon id */
public Long getPokemonId() {
    return pokemon.getId();
}

/*get equipo id */
public Long getEquipoId() {
    return equipo.getId();
}

/*same with set */
public void setPokemonId(Long id) {
    pokemon.setId(id);
}

public void setEquipoId(Long id) {
    equipo.setId(id);
}


}
