/*
In order to respect the Single Responsibility Principle of SOLID, this class was created and used
by the HTTP service instead of integrating the JSON parsing logic directly into the service.

It is responsible for parsing the API JSON responses in order to extract the required information
(name, description, height, and weight).
*/

package com.example.pokedex.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PokemonJsonParser {

    private String LocaleCode;

    public PokemonJsonParser(String localeCode) {
        if (localeCode == null){
            this.LocaleCode = "en";
        }
        else{
            this.LocaleCode = localeCode;
        }
    }

    public Integer parseJsonHeight(String jsonString) throws Exception {
        try {
            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonString);
            if (resultObject instanceof JSONObject) {
                JSONObject rootObject = (JSONObject) resultObject;
                Integer height = Math.toIntExact((Long) rootObject.get("height"));
                return height;
            }
            else {
                return null;
            }
        } catch (ParseException e) {
            System.err.println(e);
            return null;
        }
    }

    public Integer parseJsonWeight(String jsonString) throws Exception {
        try {
            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonString);
            if (resultObject instanceof JSONObject) {
                JSONObject rootObject = (JSONObject) resultObject;
                Integer height = Math.toIntExact((Long) rootObject.get("weight"));
                return height;
            }
            else {
                return null;
            }
        } catch (ParseException e) {
            System.err.println(e);
            return null;
        }
    }

    public String parseJsonName(String jsonString) throws Exception{
        try {
            JSONParser parser = new JSONParser();
            JSONObject rootObject = (JSONObject) parser.parse(jsonString);
            JSONArray namesArray = (JSONArray) rootObject.get("names");
            for (Object o: namesArray) {
                JSONObject pokemonObject = (JSONObject) o;
                JSONObject languageObject = (JSONObject) pokemonObject.get("language");
                String language = (String) languageObject.get("name");
                String pokemonName = (String) pokemonObject.get("name");
                if (language.equals(LocaleCode)) {
                    return pokemonName;
                }
            }
            return null;
        } catch (ParseException e) {
            System.err.println(e);
            return null;
        }
    }

    public String parseJsonDescription(String jsonString) throws Exception{
        try {
            JSONParser parser = new JSONParser();
            JSONObject rootObject = (JSONObject) parser.parse(jsonString);
            JSONArray namesArray = (JSONArray) rootObject.get("flavor_text_entries");
            for (Object o: namesArray) {
                JSONObject pokemonObject = (JSONObject) o;
                JSONObject languageObject = (JSONObject) pokemonObject.get("language");
                String language = (String) languageObject.get("name");
                String pokemonDescription = (String) pokemonObject.get("flavor_text");
                if (language.equals(LocaleCode)) {
                    return pokemonDescription;
                }
            }
            return null;
        } catch (ParseException e) {
            System.err.println(e);
            return null;
        }
    }
}
