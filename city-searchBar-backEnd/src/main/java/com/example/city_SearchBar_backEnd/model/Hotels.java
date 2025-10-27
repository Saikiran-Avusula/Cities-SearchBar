package com.example.city_SearchBar_backEnd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hotels")
@Data
public class Hotels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;

    private String hotelArea;
    private String hotelImageUrl;
    private String hotelName;

    @Column(nullable = false)
    private Double hotelPrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Cities city;

    // Transient field to expose cityId in JSON
    @Transient
    public Integer getCityId() {
        return city != null ? city.getCityId() : null;
    }
}
