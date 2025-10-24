package com.example.city_SearchBar_backEnd.service;

import com.example.city_SearchBar_backEnd.model.SearchInputEntity;
import com.example.city_SearchBar_backEnd.repository.SearchInputRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchInputServiceImpl implements SearchInputService {

    private static final Logger log = LoggerFactory.getLogger(SearchInputServiceImpl.class);

    @Autowired
    SearchInputRepo searchInputRepo;

    @Override
    public List<SearchInputEntity> getAllSearchInput() {
        List<SearchInputEntity> searchInputEntityList = searchInputRepo.findAll();
        System.out.println();

//        showing the searched data in console
        log.info("Showing search input cities: {}",searchInputEntityList);
        return searchInputEntityList;
    }

    @Override
    public List<SearchInputEntity> searchCities(String keyword) {
        List<SearchInputEntity> byMatchedCityNameContainingIgnoreCase = searchInputRepo.findByCityNameContainingIgnoreCase(keyword);
        log.info("Auto-suggestion results for '{}': {}", keyword, byMatchedCityNameContainingIgnoreCase);
        return byMatchedCityNameContainingIgnoreCase;
    }
}
