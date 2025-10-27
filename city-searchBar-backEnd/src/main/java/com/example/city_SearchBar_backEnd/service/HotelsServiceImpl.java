package com.example.city_SearchBar_backEnd.service;

import com.example.city_SearchBar_backEnd.model.Hotels;
import com.example.city_SearchBar_backEnd.repository.HotelsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelsServiceImpl implements HotelsService {

    @Autowired
    private final HotelsRepo hotelsRepo;

    public HotelsServiceImpl(HotelsRepo hotelsRepo) {
        this.hotelsRepo = hotelsRepo;
    }

    @Override
    public List<Hotels> getHotelsByCity(Integer cityId) {
        try {
            List<Hotels> hotels = hotelsRepo.findByCity_CityId(cityId);
            System.out.println("Found " + (hotels != null ? hotels.size() : 0) + " hotels for cityId: " + cityId);
            return hotels;
        } catch (Exception e) {
            System.err.println("Error finding hotels for cityId: " + cityId);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Hotels> findAllByCityId(Integer cityId) {
        return hotelsRepo.findByCity_CityId(cityId);
    }

    @Override
    public Hotels getHotelById(Integer hotelId) {
        return hotelsRepo.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotelId));
    }

    // @Override
    // public Page<Hotels> getHotelsByCity(Integer cityId, int page, int size) {
    // return hotelsRepo.findByCity_CityId(cityId, PageRequest.of(page, size));
    // }

    // @Override
    // public Page<Hotels> getHotelsByCity(Long cityId, int page, int size) {
    // return hotelsRepo.findByCityId(cityId, PageRequest.of(page, size));
    // }
    //
    // @Override
    // public List<Hotels> findAllByCityId(Long cityId) {
    // return hotelsRepo.findByCityId(cityId);
    // }
    //
    // @Override
    // public Hotels getHotelById(Long hotelId) {
    // return hotelsRepo.findById(hotelId)
    // .orElseThrow(() -> new RuntimeException("Hotel not found with id: " +
    // hotelId));
    // }
}
