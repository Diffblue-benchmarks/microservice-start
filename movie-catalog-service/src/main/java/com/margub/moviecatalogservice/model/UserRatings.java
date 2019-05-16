package com.margub.moviecatalogservice.model;

import java.util.List;

public class UserRatings {
    public UserRatings() {
    }

    private List<Rating> userRatings;

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }


}
