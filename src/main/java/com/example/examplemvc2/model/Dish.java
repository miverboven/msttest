package com.example.examplemvc2.model;


public class Dish {

    private int id;
    private String name;
    private int calories;
    private boolean vegetarian;

    public Dish() {
    }

    public Dish(int id, String name, int calories, boolean vegetarian) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.vegetarian = vegetarian;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
}

