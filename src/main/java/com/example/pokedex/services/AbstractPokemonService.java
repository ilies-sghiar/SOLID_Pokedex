package com.example.pokedex.services;

public abstract class AbstractPokemonService implements PropertyProviderInterface, LocalizedPropertyProviderInterface  {
    public Integer getIntProperty(String propertyName) {return null;};
    public String getStringProperty(String propertyName) {return null;};
    public void setStringPropertyLocale(String localeCode){};
    public String getStringPropertyLocale(){return null;};
    public void setId(Integer pokemonId) {};
}
