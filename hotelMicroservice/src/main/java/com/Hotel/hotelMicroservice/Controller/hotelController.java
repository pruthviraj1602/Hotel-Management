package com.Hotel.hotelMicroservice.Controller;

import com.Hotel.hotelMicroservice.Entities.Hotel;
import com.Hotel.hotelMicroservice.Services.IMPL.hotelServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class hotelController {

    @Autowired
    private hotelServiceIMPL hotelServiceIMPL;

    @PostMapping("/register-hotel")
    public ResponseEntity<Hotel> registerHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelServiceIMPL.RegisrerHotel(hotel);
        if(hotel1!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getHotels")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> allHotels = hotelServiceIMPL.getAllHotels();
        if(allHotels!=null){
            return ResponseEntity.status(HttpStatus.OK).body(allHotels);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getHotel/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Integer hotelId){
        Hotel hotel = hotelServiceIMPL.getHotel(hotelId);
        if(hotel!=null){
            return ResponseEntity.status(HttpStatus.OK).body(hotel);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/deleteHotel/{hotelId}")
    public ResponseEntity<?> deleteHotel(@PathVariable Integer hotelId){
        Boolean b = hotelServiceIMPL.deleteHotel(hotelId);
        if(b){
            return ResponseEntity.status(HttpStatus.OK).body("Hotel Deleted..");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Wrong");
    }

    @PutMapping("/updateHotel")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelServiceIMPL.updateHotel(hotel);
        if(hotel1!=null){
            return ResponseEntity.status(HttpStatus.OK).body(hotel1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
