package com.pokemondb.pokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.pokemondb.pokemon.exception.ResourceNotFoundException;
import com.pokemondb.pokemon.helper.JWTHelper;
import com.pokemondb.pokemon.repository.EntrenadorRepository;

import jakarta.servlet.http.HttpServletRequest;

import com.pokemondb.pokemon.entity.EntrenadorEntity;

@Service
public class EntrenadorService {

    @Autowired
    EntrenadorRepository oEntrenadorRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    private final String pokemonDBpassword = "bc9417f16769971028f0332b7e6b9dea8296ab967bc262a0e63435dff4ee5429"; //pass: pokemonapp


    public EntrenadorEntity get(Long id) {
        return oEntrenadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entreandor no encontrado"));

    }

    public Iterable<EntrenadorEntity> getAll() {
        return oEntrenadorRepository.findAll();
    }

    public Long create(EntrenadorEntity oEntrenadorEntity) {
        //oSessionService.onlyAdmins();
        oEntrenadorEntity.setId(null);
        oEntrenadorEntity.setPassword(pokemonDBpassword);
        return oEntrenadorRepository.save(oEntrenadorEntity).getId();
    }

    public EntrenadorEntity update(EntrenadorEntity oEntrenadorEntity) {
        //EntrenadorEntity entrenadorFromEntity = this.get(oEntrenadorEntity.getId());
         
        oEntrenadorEntity.setPassword(pokemonDBpassword);
        return oEntrenadorRepository.save(oEntrenadorEntity);
        /*oSessionService.onlyAdminsOrUsersWithIisOwnData(oEntrenadorEntity.getId());
        if (oSessionService.isUser()) {            
            oEntrenadorEntity.setRole(oEntrenadorEntity.getRole());
            oEntrenadorEntity.setPassword(pokemonDBpassword);
            return oEntrenadorRepository.save(oEntrenadorEntity);
        } else {            
            oEntrenadorEntity.setPassword(pokemonDBpassword);
            return oEntrenadorRepository.save(oEntrenadorEntity);
        }*/
        
    }

    public Long delete(Long id) {
        oSessionService.onlyAdmins();
        EntrenadorEntity oEntrenadorEntity = oEntrenadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entrenador no encontrado"));
        oEntrenadorRepository.delete(oEntrenadorEntity);
        return id;
    }

    public Page<EntrenadorEntity> getPage(Pageable pageable) {
        return oEntrenadorRepository.findAll(pageable);
    }

    public Long populate(Integer amount) {
         oSessionService.onlyAdmins();
        for (int i = 0; i < amount; i++) {
            EntrenadorEntity oEntrenadorEntity = new EntrenadorEntity();
            oEntrenadorEntity.setUsername("Entrenador " + i);
            oEntrenadorEntity.setEmail("email" + i + " @gmail.com");
            oEntrenadorEntity.setPassword(pokemonDBpassword);
            oEntrenadorEntity.setRole(true);
            oEntrenadorRepository.save(oEntrenadorEntity);
        }
        return oEntrenadorRepository.count();
    }

    public Long empty() {
         oSessionService.onlyAdmins();
        if (oEntrenadorRepository != null) {
            oEntrenadorRepository.deleteAll();
        }
        return oEntrenadorRepository.count();
    }

    /* create the method getbyusername */
    public String getUsernameById(Long id) {
        EntrenadorEntity oEntrenadorEntity = oEntrenadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entrenador no encontrado"));
        return oEntrenadorEntity.getUsername();
    }

    /* create the method validateJWT */
    public String validateJWT(String token) {
        return JWTHelper.validateJWT(token);
    }

    /* create the method login */
    public String login(EntrenadorEntity oEntrenadorEntity) {
        EntrenadorEntity oEntrenadorEntityFromDB = oEntrenadorRepository.findByUsernameAndPassword(oEntrenadorEntity.getUsername(), oEntrenadorEntity.getPassword())
                .orElseThrow(() -> new ResourceNotFoundException("Entrenador no encontrado"));
        return JWTHelper.generateJWT(oEntrenadorEntityFromDB.getUsername());
    }
}
