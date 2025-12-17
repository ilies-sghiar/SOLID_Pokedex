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
    }

    @Override
    public void runPokedex(Integer pokemonId) throws Exception {

        myPokemonService.setId(pokemonId);

        PokemonController myController = new PokemonController(myPokemonService, pokemonId);

        Pokemon myPokemon = myController.createPokemon();

        PokemonView myView = new PokemonView(myPokemon);

        myView.getView();

        System.out.printf("Pokemon %s was requested", pokemonId); // TODO remove
    }
}
