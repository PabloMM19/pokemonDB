package com.pokemondb.pokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.pokemondb.pokemon.exception.ResourceNotFoundException;
import com.pokemondb.pokemon.repository.EntrenadorRepository;
import com.pokemondb.pokemon.entity.EntrenadorEntity;

@Service
public class EntrenadorService {

    @Autowired
    EntrenadorRepository oEntrenadorRepository;

    public EntrenadorEntity get(Long id) {
        return oEntrenadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entreandor no encontrado"));

    }

    public Long create(EntrenadorEntity oEntrenadorEntity) {
        return oEntrenadorRepository.save(oEntrenadorEntity).getId();
    }

    public EntrenadorEntity update(EntrenadorEntity oEntrenadorEntity) {
        return oEntrenadorRepository.save(oEntrenadorEntity);
    }

    public Long delete(Long id) {
        EntrenadorEntity oEntrenadorEntity = oEntrenadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entrenador no encontrado"));
        oEntrenadorRepository.delete(oEntrenadorEntity);
        return id;
    }

    public Page<EntrenadorEntity> getPage(Pageable pageable) {
        return oEntrenadorRepository.findAll(pageable);
    }

    public Long populate(Integer amount) {
        for (int i = 0; i < amount; i++) {
            EntrenadorEntity oEntrenadorEntity = new EntrenadorEntity();
            oEntrenadorEntity.setUsername("Entrenador " + i);
            oEntrenadorEntity.setEmail("email" + i + " @gmail.com");
            oEntrenadorEntity.setPassword("Prueba123");
            oEntrenadorEntity.setRole(false);
            oEntrenadorRepository.save(oEntrenadorEntity);
        }
        return oEntrenadorRepository.count();
    }
}
