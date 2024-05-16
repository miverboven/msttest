package com.example.examplemvc2.dao;

import com.example.examplemvc2.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class DishDao {

    @Autowired
    private JdbcClient jdbcClient;

    public List<Dish> findAll() {
        return jdbcClient.sql("SELECT id, name, calories, vegetarian FROM culinary.dishes")
                .query(Dish.class)
                .list();
    }

    public Optional<Dish> findById(int id) {
        return jdbcClient.sql("SELECT id, name, calories, vegetarian FROM culinary.dishes WHERE id = :id")
                .param("id", id)
                .query(Dish.class)
                .optional();
    }

    public void create(Dish dish) {
        jdbcClient.sql("INSERT INTO culinary.dishes (name, calories, vegetarian) VALUES (?, ?, ?)")
                .params(List.of(dish.getName(), dish.getCalories(), dish.isVegetarian() ? 1 : 0))
                .update();
    }

    public void update(Dish dish, int id) {
        jdbcClient.sql("UPDATE culinary.dishes SET name = ?, calories = ?, vegetarian = ? WHERE id = ?")
                .params(List.of(dish.getName(), dish.getCalories(), dish.isVegetarian() ? 1 : 0, id))
                .update();
    }

    public void delete(int id) {
        jdbcClient.sql("DELETE FROM culinary.dishes WHERE id = ?")
                .param("id", id)
                .update();
    }
}

