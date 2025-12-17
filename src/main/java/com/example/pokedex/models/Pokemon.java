package com.example.pokedex.models;

public class Pokemon {
    private Integer Id;
    private String Name;
    private String Description;
    private Integer Height;
    private Integer Weight;

    public Pokemon(Integer id, String name, String Description , Integer height, Integer weight) {
        this.Id = id;
        this.Name = name;
        this.Description = Description;
        this.Height = height;
        this.Weight = weight;
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public Integer getHeight() {
        return Height;
    }

    public Integer getWeight() {
        return Weight;
    }

}