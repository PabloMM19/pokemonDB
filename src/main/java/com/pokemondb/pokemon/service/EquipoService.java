package com.pokemondb.pokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import com.pokemondb.pokemon.entity.EquipoEntity;
import com.pokemondb.pokemon.exception.ResourceNotFoundException;
import com.pokemondb.pokemon.repository.EquipoRepository;

@Service
public class EquipoService {
    @Autowired
    EquipoRepository oEquipoRepository;

    public EquipoEntity get(Long id) {
        return oEquipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado"));
    }

    public Long create(EquipoEntity oEquipoEntity) {
        return oEquipoRepository.save(oEquipoEntity).getId();
    }

    public EquipoEntity update(EquipoEntity oEquipoEntity) {
        return oEquipoRepository.save(oEquipoEntity);
    }

    public Long delete(Long id) {
        EquipoEntity oEquipoEntity = oEquipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado"));
        oEquipoRepository.delete(oEquipoEntity);
        return id;
    }

    public Page<EquipoEntity> getPage(Pageable pageable) {
        return oEquipoRepository.findAll(pageable);
    }

    public Long populate(Integer amount) {
        for (int i = 0; i < amount; i++) {
            EquipoEntity oEquipoEntity = new EquipoEntity();
            oEquipoEntity.setNombre("Equipo " + i);
            oEquipoEntity.setDescripcion("Equipo de prueba para la bbdd ");
            oEquipoRepository.save(oEquipoEntity);
        }
        return oEquipoRepository.count();
    }
}
