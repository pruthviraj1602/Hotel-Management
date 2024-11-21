package com.Hotel.hotelMicroservice.Services;

import com.Hotel.hotelMicroservice.Entities.Hotel;

import java.util.List;

public interface hotelService {

    public Hotel RegisrerHotel(Hotel hotel);

    public List<Hotel> getAllHotels();

    public Hotel getHotel(Integer hotelId);

    public Boolean deleteHotel(Integer hotelId);

    public Hotel updateHotel(Hotel hotel);
}
