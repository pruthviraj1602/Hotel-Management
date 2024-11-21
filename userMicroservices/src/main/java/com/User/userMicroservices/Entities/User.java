package com.User.userMicroservices.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String userEmail;
    private String userPassword;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
