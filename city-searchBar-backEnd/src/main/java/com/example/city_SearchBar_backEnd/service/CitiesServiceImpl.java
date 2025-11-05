package com.example.city_SearchBar_backEnd.service;

import com.example.city_SearchBar_backEnd.model.Cities;
import com.example.city_SearchBar_backEnd.repository.CitiesRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesServiceImpl implements CitiesService {

    private static final Logger log = LoggerFactory.getLogger(CitiesServiceImpl.class);

    @Autowired
    CitiesRepo citiesRepo;

    @Override
    public List<Cities> getAllSearchInput() {
        List<Cities> citiesList = citiesRepo.findAll();
        System.out.println();

//        showing the searched data in console
        log.info("Showing search input cities: {}", citiesList);
        return citiesList;
    }

    @Override
    public List<Cities> searchCities(String keyword) {
        List<Cities> byMatchedCityNameContainingIgnoreCase = citiesRepo.findByCityNameContainingIgnoreCase(keyword);
        log.info("Auto-suggestion results for '{}': {}", keyword, byMatchedCityNameContainingIgnoreCase);
        return byMatchedCityNameContainingIgnoreCase;
    }

}
