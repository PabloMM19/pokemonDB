package com.pokemondb.pokemon.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemon")     
public class PokemonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo1;
    private String tipo2;
    private String ataque1;
    private String ataque2;
    private String ataque3;
    private String ataque4;
    private int generacion;
    private String habilidad;
    private int ataque;
    private int defensa;
    private int ataque_Especial;
    private int defensa_Especial;
    private int velocidad;
    private int salud;
    private String objeto;
    private String naturaleza;
    private int nivel;

    @OneToMany(mappedBy = "pokemon", fetch = jakarta.persistence.FetchType.LAZY)
    private List<EquipoPokemonEntity> listaPokemon;

    public PokemonEntity() {
        listaPokemon = new java.util.ArrayList<>();
    }

    public PokemonEntity(Long id, String nombre, String tipo1, String tipo2, String ataque1, String ataque2,
            String ataque3, String ataque4, int generacion, String habilidad, int ataque, int defensa,
            int ataque_Especial, int defensa_Especial, int velocidad, int salud, String objeto, String naturaleza,
            int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.ataque1 = ataque1;
        this.ataque2 = ataque2;
        this.ataque3 = ataque3;
        this.ataque4 = ataque4;
        this.generacion = generacion;
        this.habilidad = habilidad;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataque_Especial = ataque_Especial;
        this.defensa_Especial = defensa_Especial;
        this.velocidad = velocidad;
        this.salud = salud;
        this.objeto = objeto;
        this.naturaleza = naturaleza;
        this.nivel = nivel;
    }

    public PokemonEntity(String nombre, String tipo1, String tipo2, String ataque1, String ataque2, String ataque3,
            String ataque4, int generacion, String habilidad, int ataque, int defensa, int ataque_Especial,
            int defensa_Especial, int velocidad, int salud, String objeto, String naturaleza, int nivel) {
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.ataque1 = ataque1;
        this.ataque2 = ataque2;
        this.ataque3 = ataque3;
        this.ataque4 = ataque4;
        this.generacion = generacion;
        this.habilidad = habilidad;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataque_Especial = ataque_Especial;
        this.defensa_Especial = defensa_Especial;
        this.velocidad = velocidad;
        this.salud = salud;
        this.objeto = objeto;
        this.naturaleza = naturaleza;
        this.nivel = nivel;
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

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public String getAtaque1() {
        return ataque1;
    }

    public void setAtaque1(String ataque1) {
        this.ataque1 = ataque1;
    }

    public String getAtaque2() {
        return ataque2;
    }

    public void setAtaque2(String ataque2) {
        this.ataque2 = ataque2;
    }

    public String getAtaque3() {
        return ataque3;
    }

    public void setAtaque3(String ataque3) {
        this.ataque3 = ataque3;
    }

    public String getAtaque4() {
        return ataque4;
    }

    public void setAtaque4(String ataque4) {
        this.ataque4 = ataque4;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaque_Especial() {
        return ataque_Especial;
    }

    public void setAtaque_Especial(int ataque_Especial) {
        this.ataque_Especial = ataque_Especial;
    }

    public int getDefensa_Especial() {
        return defensa_Especial;
    }

    public void setDefensa_Especial(int defensa_Especial) {
        this.defensa_Especial = defensa_Especial;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getListaPokemon() {
        return listaPokemon.size();
    }

}
