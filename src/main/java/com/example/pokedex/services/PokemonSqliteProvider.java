package com.example.pokedex.services;

import org.sqlite.SQLiteConfig;

import java.sql.*;

public class PokemonSqliteProvider extends AbstractPokemonService {
    private Integer PokemonId;

    private String LocaleCode;

    private String DBpath;

    public PokemonSqliteProvider(String dbpath) {
        this.DBpath = dbpath;
    }

    public void setId(Integer pokemonId) {

        this.PokemonId = pokemonId;

    }

    @Override
    public Integer getIntProperty(String propertyName) {
        if (propertyName.equals("height")) {
            String jdbcUrl = "jdbc:sqlite:" + this.DBpath;

            SQLiteConfig config = new SQLiteConfig();
            config.setEncoding(SQLiteConfig.Encoding.UTF8);

            try (Connection conn = DriverManager.getConnection(jdbcUrl, config.toProperties());
                    PreparedStatement stmt = conn.prepareStatement("SELECT height FROM pokemons WHERE id = ?")) {

                stmt.setInt(1, this.PokemonId);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt("height");
                    } else {
                        return null;
                    }
                }
            } catch (Exception e) {
                System.err.println("Erreur lors de la récupération de la taille : " + e.getMessage());
                return null;
            }
        }
        if (propertyName.equals("weight")) {
            String jdbcUrl = "jdbc:sqlite:" + this.DBpath;

            SQLiteConfig config = new SQLiteConfig();
            config.setEncoding(SQLiteConfig.Encoding.UTF8);

            try (Connection conn = DriverManager.getConnection(jdbcUrl, config.toProperties());
                    PreparedStatement stmt = conn.prepareStatement("SELECT weight FROM pokemons WHERE id = ?")) {

                stmt.setInt(1, this.PokemonId);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt("weight");
                    } else {
                        return null;
                    }
                }
            } catch (Exception e) {
                System.err.println("Erreur lors de la récupération du poids : " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override
    public String getStringProperty(String propertyName) {

        if (propertyName.equals("name")) {
            String jdbcUrl = "jdbc:sqlite:" + this.DBpath;

            SQLiteConfig config = new SQLiteConfig();
            config.setEncoding(SQLiteConfig.Encoding.UTF8);

            try (Connection conn = DriverManager.getConnection(jdbcUrl, config.toProperties());
                    PreparedStatement stmt = conn.prepareStatement("SELECT name FROM pokemons WHERE id = ?")) {

                stmt.setInt(1, this.PokemonId);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("name");
                    } else {
                        return null;
                    }
                }
            } catch (Exception e) {
                System.err.println("Erreur lors de la récupération du nom : " + e.getMessage());
                return null;
            }
        }

        if (propertyName.equals("description")) {
            String jdbcUrl = "jdbc:sqlite:" + this.DBpath;

            SQLiteConfig config = new SQLiteConfig();
            config.setEncoding(SQLiteConfig.Encoding.UTF8);

            try (Connection conn = DriverManager.getConnection(jdbcUrl, config.toProperties());
                    PreparedStatement stmt = conn.prepareStatement("SELECT description FROM pokemons WHERE id = ?")) {

                stmt.setInt(1, this.PokemonId);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("description");
                    } else {
                        return null;
                    }
                }
            } catch (Exception e) {
                System.err.println("Erreur lors de la récupération de la description : " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public void setStringPropertyLocale(String localeCode) {
        this.LocaleCode = localeCode; // mais n'est jamais utilisé pour SQL (opération fictive)
    };

    public String getStringPropertyLocale() {
        return this.LocaleCode;
    }
}
