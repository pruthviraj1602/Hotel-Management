package com.Hotel.hotelMicroservice.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;
    private String hotelName;
    private String hotelLocation;
    private String hotelPincode;
}
