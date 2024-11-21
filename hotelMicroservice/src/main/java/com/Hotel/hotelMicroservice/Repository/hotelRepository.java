package com.Hotel.hotelMicroservice.Repository;

import com.Hotel.hotelMicroservice.Entities.Hotel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface hotelRepository extends JpaRepository<Hotel,Integer> {

    public Hotel getHotelByHotelId(Integer hotelId);

    @Transactional
    public Integer deleteHotelByHotelId(Integer hotelId);
}
