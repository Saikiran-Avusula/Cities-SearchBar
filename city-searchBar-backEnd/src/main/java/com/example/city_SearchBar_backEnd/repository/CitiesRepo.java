package com.example.city_SearchBar_backEnd.repository;

import com.example.city_SearchBar_backEnd.model.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitiesRepo extends JpaRepository<Cities, Integer> {

//    Custom query method for city search (used for auto-suggestions)
    List<Cities> findByCityNameContainingIgnoreCase(String cityName);
}
