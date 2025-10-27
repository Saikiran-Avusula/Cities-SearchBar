package com.example.city_SearchBar_backEnd.controller;

import com.example.city_SearchBar_backEnd.model.Cities;
import com.example.city_SearchBar_backEnd.service.CitiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
@CrossOrigin(origins = "http://localhost:5173")
public class CitiesController {

    private static final Logger log = LoggerFactory.getLogger(CitiesController.class);
    @Autowired
    CitiesService citiesService;

    @GetMapping("/getAllCities")
    public ResponseEntity<List<Cities>> getAllSearchInputs() {
        List<Cities> citiesList = citiesService.getAllSearchInput();
        System.out.println();
        log.info("---From controller---");
        log.info("City Name: {}", citiesList);
        return ResponseEntity.ok(citiesList);
    }

    @GetMapping("/suggest")
    public ResponseEntity<List<Cities>> suggestCities(@RequestParam(required = false) String keyword) {
        log.info("Received search keyword: {}", keyword);
        List<Cities> suggestions = citiesService.searchCities(keyword);
        return ResponseEntity.ok(suggestions);
    }
}
