package com.example.city_SearchBar_backEnd.repository;

import com.example.city_SearchBar_backEnd.model.SearchInputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchInputRepo extends JpaRepository<SearchInputEntity, Integer> {

//    Custom query method for city search (used for auto-suggestions)
    List<SearchInputEntity> findByCityNameContainingIgnoreCase(String cityName);
}
