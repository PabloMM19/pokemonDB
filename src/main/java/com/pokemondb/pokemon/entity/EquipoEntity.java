package com.pokemondb.pokemon.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipo")
public class EquipoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "equipo", fetch = jakarta.persistence.FetchType.LAZY)
    private List<EquipoPokemonEntity> listaEquipos;

    @ManyToOne
    @JoinColumn(name = "id_entrenador")
    private EntrenadorEntity entrenador;

    public EquipoEntity() {
        listaEquipos = new java.util.ArrayList<>();
    }

    public EquipoEntity(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public EquipoEntity(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EntrenadorEntity getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(EntrenadorEntity entrenador) {
        this.entrenador = entrenador;
    }

    public int getListaEquipos() {
        return listaEquipos.size();
    }
    
}
