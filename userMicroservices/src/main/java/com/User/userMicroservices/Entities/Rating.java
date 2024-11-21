package com.User.userMicroservices.Entities;

import lombok.Data;

@Data
public class Rating {
    private Integer ratingId;
    private Integer userId;
    private Integer hotelId;
    private int ratings;
    private String feedback;

    private Hotel hotel;

}
