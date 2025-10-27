package com.example.city_SearchBar_backEnd.controller;

import com.example.city_SearchBar_backEnd.model.Hotels;
import com.example.city_SearchBar_backEnd.service.HotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hotels")
@CrossOrigin(origins = "http://localhost:5173")
public class HotelsController {

    @Autowired
    private final HotelsService hotelsService;

    public HotelsController(HotelsService hotelsService) {
        this.hotelsService = hotelsService;
    }

    // Get hotels by city ID
    @GetMapping("/by-city/{cityId}")
    public List<Hotels> getHotelsByCity(@PathVariable Integer cityId) {
        return hotelsService.getHotelsByCity(cityId);
    }

    // Get all hotels by city ID
    @GetMapping("/by-city/{cityId}/all")
    public List<Hotels> getAllHotelsByCity(@PathVariable Integer cityId) {
        return hotelsService.findAllByCityId(cityId);
    }

    // Get hotels by hotelId
    @GetMapping("/{hotelId}")
    public Hotels getHotelById(@PathVariable Integer hotelId) {
        return hotelsService.getHotelById(hotelId);
    }
}
