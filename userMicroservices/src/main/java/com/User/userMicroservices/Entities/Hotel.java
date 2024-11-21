package com.User.userMicroservices.Entities;

import lombok.Data;

@Data
public class Hotel {
    private Integer hotelId;
    private String hotelName;
    private String hotelLocation;
    private String hotelPincode;
}
