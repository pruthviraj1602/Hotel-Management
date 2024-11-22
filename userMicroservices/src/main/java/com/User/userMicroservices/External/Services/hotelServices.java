package com.User.userMicroservices.External.Services;

import com.User.userMicroservices.Entities.Hotel;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "HOTELMICROSERVICE")
public interface hotelServices {

    @GetMapping("/hotel/getHotel/{hotelId}")
    public Hotel getHotel(@PathVariable Integer hotelId);
}
