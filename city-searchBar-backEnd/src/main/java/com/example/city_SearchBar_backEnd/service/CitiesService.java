package com.example.city_SearchBar_backEnd.service;

import com.example.city_SearchBar_backEnd.model.Cities;

import java.util.List;

public interface CitiesService {

//    fetching all the cities
    public List<Cities> getAllSearchInput();

//    searching city names dynamically for search suggestions
    List<Cities> searchCities(String keyword);

}
