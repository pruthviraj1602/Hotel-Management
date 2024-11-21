package com.Rating.ratingMicroservice.Services.IMPL;

import com.Rating.ratingMicroservice.Entities.Rating;
import com.Rating.ratingMicroservice.Repositories.ratingRepository;
import com.Rating.ratingMicroservice.Services.ratingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ratingServiceIMPL implements ratingServices {


    @Autowired
    private ratingRepository ratingRepository;

    @Override
    public Rating SaveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(Integer userId) {
        return ratingRepository.getRatingByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(Integer hotelId) {
        return ratingRepository.getRatingByHotelId(hotelId);
    }
}
