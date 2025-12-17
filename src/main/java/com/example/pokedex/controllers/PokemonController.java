/*
In order to respect the Single Responsibility Principle of SOLID, this class is only responsible
for instantiating Pokemon objects from data retrieved from a service.

This class represents the Controller layer of our Model-View-Controller (MVC) architecture.
*/

package com.example.pokedex.controllers;

// Dependency Inversion Principle: the controller depends on an abstraction rather than a concrete implementation.

import com.example.pokedex.services.AbstractPokemonService;
import com.example.pokedex.models.Pokemon;


public class PokemonController {
    private AbstractPokemonService PokemonService;

    private Integer PokemonId;

    public PokemonController(AbstractPokemonService pokemonService, Integer pokemonId) {
        this.PokemonService = pokemonService;

        this.PokemonId = pokemonId;
    }

    public Pokemon createPokemon() {
        Integer height = PokemonService.getIntProperty("height");
        Integer weight = PokemonService.getIntProperty("weight");
        String description = PokemonService.getStringProperty("description");
        String name = PokemonService.getStringProperty("name");
        Pokemon pokemon = new Pokemon(PokemonId, name, description, height, weight);
        return pokemon;
    }
}
