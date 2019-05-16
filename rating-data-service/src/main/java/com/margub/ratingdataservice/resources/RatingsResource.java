package com.margub.ratingdataservice.resources;

import com.margub.ratingdataservice.model.Rating;
import com.margub.ratingdataservice.model.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {


    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {

        return new Rating(movieId, 4);
    }

    @RequestMapping("users/{userId}")
    public UserRatings getUserRating(@PathVariable("userId") String userId) {

        //Get all rated movieIDs; Doing hardCode
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );
        UserRatings userRatings = new UserRatings();
        userRatings.setUserRatings(ratings);
        return userRatings;
    }


}
