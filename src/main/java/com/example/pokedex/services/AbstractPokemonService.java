/*
This service abstraction respects 2 SOLID principles:

Dependency Inversion Principle: the controller depends only on this abstraction, and the concrete
dependency is injected by the PokedexRunner.

Open-Closed Principle: new services can be added without refactoring the controller code nor
the already existing services.
*/

package com.example.pokedex.services;

public abstract class AbstractPokemonService implements PropertyProviderInterface, LocalizedPropertyProviderInterface  {

    protected Integer PokemonId;

    protected String LocaleCode;

    public Integer getIntProperty(String propertyName) {return null;};
    public String getStringProperty(String propertyName) {return null;};

    public void setStringPropertyLocale(String localeCode) {
        this.LocaleCode = localeCode;
    };

    public String getStringPropertyLocale() {
        return this.LocaleCode;
    }

    public void setId(Integer pokemonId) {

        this.PokemonId = pokemonId;

    }
}
