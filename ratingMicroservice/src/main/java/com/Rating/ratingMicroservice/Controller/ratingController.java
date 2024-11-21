package com.Rating.ratingMicroservice.Controller;

import com.Rating.ratingMicroservice.Entities.Rating;
import com.Rating.ratingMicroservice.Services.IMPL.ratingServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class ratingController {

    @Autowired
    private ratingServiceIMPL ratingServiceIMPL;

    @PostMapping("/register-rating")
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
        Rating rating1 = ratingServiceIMPL.SaveRating(rating);
        if(rating1!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getAllRating")
    public ResponseEntity<List<Rating>> getAllRating(){
        List<Rating> allRatings = ratingServiceIMPL.getAllRatings();
        if(allRatings!=null){
            return ResponseEntity.status(HttpStatus.OK).body(allRatings);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getUserRating/{userId}")
    public ResponseEntity<List<Rating>> getUserRating(@PathVariable Integer userId){
        List<Rating> ratingByUserId = ratingServiceIMPL.getRatingByUserId(userId);
        if(ratingByUserId!=null){
            return ResponseEntity.status(HttpStatus.OK).body(ratingByUserId);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getHotelRating/{hotelId}")
    public ResponseEntity<List<Rating>> getHotelRating(@PathVariable Integer hotelId){
        List<Rating> ratingByHotelId = ratingServiceIMPL.getRatingByHotelId(hotelId);
        if(ratingByHotelId!=null){
            return ResponseEntity.status(HttpStatus.OK).body(ratingByHotelId);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
