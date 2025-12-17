package com.example.pokedex;

import com.example.pokedex.services.PokemonSqliteProvider;
import com.example.pokedex.services.AbstractPokemonService;
import com.example.pokedex.services.PokemonHttpProvider;
import com.example.pokedex.utilities.AbstractPokedexRunner;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.controllers.PokemonController;
import com.example.pokedex.views.PokemonView;

public class PokedexRunner extends AbstractPokedexRunner  {

    private AbstractPokemonService myPokemonService; 

    @Override
    public void onOptionsChange(DataSource dataSource, String dbPath) throws Exception {
        if (dataSource == DataSource.POKEAPI){
            this.myPokemonService = new PokemonHttpProvider();
        }
        else{
            this.myPokemonService = new PokemonSqliteProvider(dbPath);
        }
        this.setupServiceLocale(this.myPokemonService); 

        // Liskov Substitution Principle: myPokemonService is of type AbstractPokemonService, 
        // but we assign it a subclass (either PokemonHttpProvider or PokemonSqliteProvider) 
        // without altering the behavior of the method.
    }

    @Override
    public void runPokedex(Integer pokemonId) throws Exception {

        myPokemonService.setId(pokemonId);

        PokemonController myController = new PokemonController(myPokemonService, pokemonId); // Dependency Injection

        Pokemon myPokemon = myController.createPokemon();

        PokemonView myView = new PokemonView(myPokemon);

        myView.getView();

    }
}
