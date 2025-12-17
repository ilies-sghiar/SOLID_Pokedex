/*
In order to respect the Single Responsibility Principle of SOLID, this class is only responsible
for displaying the information of a Pokémon.

This class represents the View layer of our Model-View-Controller (MVC) architecture.
*/


package com.example.pokedex.views;

import com.example.pokedex.models.Pokemon;

public class PokemonView {

    private Pokemon pokemon;

    public PokemonView(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void getView() {
    System.out.println("=============================");
    System.out.println("Pokémon # " + safeToString(pokemon.getId()));
    System.out.println("Nom : " + safeToString(pokemon.getName()));
    System.out.println("Description : " + safeToString(pokemon.getDescription()));
    System.out.println("Taille : " + safeToString(pokemon.getHeight()));
    System.out.println("Poids : " + safeToString(pokemon.getWeight()));
    System.out.println("=============================");
}

    private String safeToString(Object obj) {
        return (obj != null) ? obj.toString() : "Information non disponible";
    }
}

