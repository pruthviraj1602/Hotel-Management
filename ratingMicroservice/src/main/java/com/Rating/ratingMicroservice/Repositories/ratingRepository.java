package com.Rating.ratingMicroservice.Repositories;

import com.Rating.ratingMicroservice.Entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ratingRepository extends JpaRepository<Rating,Integer> {

    public List<Rating> getRatingByUserId(Integer userId);

    public List<Rating> getRatingByHotelId(Integer hotelId);
}
