package com.example.pokedex.services;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class PokemonHttpProvider extends AbstractPokemonService {

    private Integer PokemonId;

    private String LocaleCode;

    public void setId(Integer pokemonId) {

        this.PokemonId = pokemonId;

    }

    @Override
    public Integer getIntProperty(String propertyName) {
        PokemonJsonParser jsonParser = new PokemonJsonParser(this.LocaleCode);
        if (propertyName.equals("height")) {
            try {

                /* Setup HTTP Client */
                CloseableHttpClient httpClient = HttpClientBuilder.create().build();

                /* Prepare HTTP request */
                HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/" + PokemonId);
                // necessary header to get a JSON response
                request.addHeader("content-type", "application/json");
                // run the request
                CloseableHttpResponse response = httpClient.execute(request);

                int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode == 200) {
                    HttpEntity responseEntity = response.getEntity();
                    if (responseEntity != null) {
                        String responseBody = EntityUtils.toString(responseEntity, "UTF-8");
                        return jsonParser.parseJsonHeight(responseBody);
                    }
                }  
                
                else {
                    return null;
                }

            } catch (Exception e) {
                System.err.println(e);
                return null;
            }

        }
        if (propertyName.equals("weight")) {
            try {

                /* Setup HTTP Client */
                CloseableHttpClient httpClient = HttpClientBuilder.create().build();

                /* Prepare HTTP request */
                HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/" + PokemonId);
                // necessary header to get a JSON response
                request.addHeader("content-type", "application/json");
                // run the request
                CloseableHttpResponse response = httpClient.execute(request);

                int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode == 200) {
                    HttpEntity responseEntity = response.getEntity();
                    if (responseEntity != null) {
                        String responseBody = EntityUtils.toString(responseEntity, "UTF-8");
                        return jsonParser.parseJsonWeight(responseBody);
                    }
                } 
                 else {
                    return null;
                }

            } catch (Exception e) {
                System.err.println(e);
                return null;
            }
        }
        return null;
    }

    @Override
    public String getStringProperty(String propertyName) {
        PokemonJsonParser jsonParser = new PokemonJsonParser(this.LocaleCode);

        if (propertyName.equals("name")) {
            try {

                /* Setup HTTP Client */
                CloseableHttpClient httpClient = HttpClientBuilder.create().build();

                /* Prepare HTTP request */
                HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon-species/" + PokemonId);
                // necessary header to get a JSON response
                request.addHeader("content-type", "application/json");
                // run the request
                CloseableHttpResponse response = httpClient.execute(request);

                int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode == 200) {
                    HttpEntity responseEntity = response.getEntity();
                    if (responseEntity != null) {
                        String responseBody = EntityUtils.toString(responseEntity, "UTF-8");
                        return jsonParser.parseJsonName(responseBody);
                    }
                } 
                else {
                    return null;
                }

            } catch (Exception e) {
                System.err.println(e);
                return null;
            }
        }

        if (propertyName.equals("description")) {
            try {

                /* Setup HTTP Client */
                CloseableHttpClient httpClient = HttpClientBuilder.create().build();

                /* Prepare HTTP request */
                HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon-species/" + PokemonId);
                // necessary header to get a JSON response
                request.addHeader("content-type", "application/json");
                // run the request
                CloseableHttpResponse response = httpClient.execute(request);

                int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode == 200) {
                    HttpEntity responseEntity = response.getEntity();
                    if (responseEntity != null) {
                        String responseBody = EntityUtils.toString(responseEntity, "UTF-8");
                        return jsonParser.parseJsonDescription(responseBody);
                    }
                } 
                else {
                    return null;
                }

            } catch (Exception e) {
                System.err.println(e);
                return null;
            }
        }
        return null;
    }

    public void setStringPropertyLocale(String localeCode) {
        this.LocaleCode = localeCode;
    };

    public String getStringPropertyLocale() {
        return this.LocaleCode;
    }
}
