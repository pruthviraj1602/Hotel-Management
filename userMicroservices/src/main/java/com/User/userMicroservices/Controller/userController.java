package com.User.userMicroservices.Controller;

import com.User.userMicroservices.Entities.Hotel;
import com.User.userMicroservices.Entities.Rating;
import com.User.userMicroservices.Entities.User;
import com.User.userMicroservices.External.Services.hotelServices;
import com.User.userMicroservices.External.Services.ratingService;
import com.User.userMicroservices.Services.IMPL.userServiceIMPL;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userServiceIMPL userServiceIMPL;

    //Used for the microservices communication
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private hotelServices hotelServices;

    @Autowired
    private ratingService ratingService;



    @PostMapping("/register-user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User user1 = userServiceIMPL.saveUser(user);
        if(user1!=null){
            return ResponseEntity.status(HttpStatus.OK).body(user1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/AllUsers")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userServiceIMPL.getAllUser();

        if(allUser!=null){
            return ResponseEntity.status(HttpStatus.OK).body(allUser);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Integer userId){
        User user = userServiceIMPL.getUser(userId);

        //Gating the data using localhost url
//        Rating[] ratingOUser= restTemplate.getForEntity("http://RATINGMICROSERVICE/rating/getUserRating/"+userId, Rating[].class).getBody();

        Rating[] ratingOUser=ratingService.getUserRating(userId).getBody().toArray(new Rating[0]);
                //Now put in the arry list
        List<Rating> ratings = Arrays.stream(ratingOUser).toList();

        //Getting the hotel throw the id that the stored int the rating services
        List<Rating> ratingList = ratings.stream().map(rating -> {
//            Hotel body = restTemplate.getForEntity("http://HOTELMICROSERVICE/hotel/getHotel/"+rating.getHotelId(), Hotel.class).getBody();

            Hotel body=hotelServices.getHotel(rating.getHotelId());
            rating.setHotel(body);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }



    @PutMapping("/update-User")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User user1 = userServiceIMPL.updateUser(user);
        if(user1!=null){
            return ResponseEntity.status(HttpStatus.OK).body(user1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
        Boolean b = userServiceIMPL.deleteUser(userId);
        if(b){
            return ResponseEntity.status(HttpStatus.OK).body("User Deleted "+userId);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Not Deleted");
    }
}
