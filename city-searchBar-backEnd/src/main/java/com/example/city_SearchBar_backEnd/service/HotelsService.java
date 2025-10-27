package com.example.city_SearchBar_backEnd.service;

import com.example.city_SearchBar_backEnd.model.Hotels;
// import org.springframework.data.domain.Page;
import java.util.List;

public interface HotelsService {
    // Get hotels by cityId (non-paginated)
    List<Hotels> getHotelsByCity(Integer cityId);

    // Get all hotels by cityId without pagination
    List<Hotels> findAllByCityId(Integer cityId);

    // Get hotel by hotelId
    Hotels getHotelById(Integer hotelId);
//
//    // Optional paginated method
//    Page<Hotels> getHotelsByCity(Integer cityId, int page, int size);
}
