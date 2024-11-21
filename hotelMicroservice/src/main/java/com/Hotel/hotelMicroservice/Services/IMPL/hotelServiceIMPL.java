package com.Hotel.hotelMicroservice.Services.IMPL;

import com.Hotel.hotelMicroservice.Entities.Hotel;
import com.Hotel.hotelMicroservice.Repository.hotelRepository;
import com.Hotel.hotelMicroservice.Services.hotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class hotelServiceIMPL implements hotelService {

    @Autowired
    private hotelRepository hotelRepository;

    @Override
    public Hotel RegisrerHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(Integer hotelId) {
        return hotelRepository.getHotelByHotelId(hotelId);
    }

    @Override
    public Boolean deleteHotel(Integer hotelId) {
        Integer i = hotelRepository.deleteHotelByHotelId(hotelId);
        return i!=null;
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
