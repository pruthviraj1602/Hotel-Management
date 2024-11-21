package com.User.userMicroservices.Controller;

import com.User.userMicroservices.Entities.Hotel;
import com.User.userMicroservices.Entities.Rating;
import com.User.userMicroservices.Entities.User;
import com.User.userMicroservices.Services.IMPL.userServiceIMPL;
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

    @Autowired
    private RestTemplate restTemplate;



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
        Rating[] ratingOUser= restTemplate.getForEntity("http://localhost:8083/rating/getUserRating/"+userId, Rating[].class).getBody();

        List<Rating> ratings = Arrays.stream(ratingOUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            Hotel body = restTemplate.getForEntity("http://localhost:8082/hotel/getHotel/"+rating.getHotelId(), Hotel.class).getBody();

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
