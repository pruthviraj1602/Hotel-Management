package com.Rating.ratingMicroservice.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratingId;
    private Integer userId;
    private Integer hotelId;
    private int ratings;
    private String feedback;
}
