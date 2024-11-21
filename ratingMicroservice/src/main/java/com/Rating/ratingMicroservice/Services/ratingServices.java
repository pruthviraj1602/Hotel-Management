package com.Rating.ratingMicroservice.Services;

import com.Rating.ratingMicroservice.Entities.Rating;

import java.util.List;

public interface ratingServices {

    public Rating SaveRating(Rating rating);

    public List<Rating> getAllRatings();

    public List<Rating> getRatingByUserId(Integer userId);

    public List<Rating> getRatingByHotelId(Integer hotelId);
}
