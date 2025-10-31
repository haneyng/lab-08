package com.example.lab08;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomList {
    private List<City> cities;

    public CustomList() {
        this.cities = new ArrayList<>();
    }

    public void addCity(City city) {
        cities.add(city);
    }


    // Will be implemented later using TDD (leave blank for now)
    // public boolean hasCity(City city) { ... }
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    public void deleteCity(City city) {
        if (hasCity(city)) {
            cities.remove(city);
        } else {
            throw new RuntimeException("Cannot delete a city that doesn't exist.");
        }
    }
    public int countCities() {
        return cities.size();
    }
}