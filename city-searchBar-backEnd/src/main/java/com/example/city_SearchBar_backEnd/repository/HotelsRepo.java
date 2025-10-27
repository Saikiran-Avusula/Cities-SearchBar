package com.example.city_SearchBar_backEnd.repository;

import com.example.city_SearchBar_backEnd.model.Hotels;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HotelsRepo extends JpaRepository<Hotels, Integer> {
    // Get all hotels by city ID using JPQL
    @Query("SELECT h FROM Hotels h WHERE h.city.cityId = :cityId")
    List<Hotels> findByCity_CityId(@Param("cityId") Integer cityId);
}
