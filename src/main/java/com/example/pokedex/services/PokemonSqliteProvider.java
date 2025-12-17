/*
In order to respect the Single Responsibility Principle of SOLID, this class is only responsible
for performing SQL queries on the database, so that the controller can later instantiate a Pokemon
from the retrieved results.
*/


package com.example.pokedex.services;

import org.sqlite.SQLiteConfig;

import java.sql.*;

public class PokemonSqliteProvider extends AbstractPokemonService {

    private String DBpath;

    public PokemonSqliteProvider(String dbpath) {
        super();
        this.DBpath = dbpath;
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
                return null;
            }
        }
        return null;
    }

    @Override
    public void setStringPropertyLocale(String localeCode) {
    }

    @Override
    public String getStringPropertyLocale() {
        return "fr";
    }
}
