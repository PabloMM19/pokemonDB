package com.pokemondb.pokemon.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemondb.pokemon.entity.EntrenadorEntity;
import com.pokemondb.pokemon.service.SessionService;

@RestController
@RequestMapping("/session")
public class SessionApi {
    @Autowired
    private SessionService sessionService;
}
