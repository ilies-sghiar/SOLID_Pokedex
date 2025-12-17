package com.example.pokedex.controllers;

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
