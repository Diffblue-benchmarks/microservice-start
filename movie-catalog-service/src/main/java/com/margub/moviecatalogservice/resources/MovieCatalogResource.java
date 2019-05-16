package com.margub.moviecatalogservice.resources;

import com.margub.moviecatalogservice.model.CatlogItem;
import com.margub.moviecatalogservice.model.Movie;
import com.margub.moviecatalogservice.model.Rating;
import com.margub.moviecatalogservice.model.UserRatings;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientbuilder;

    @RequestMapping("/{userID}")
    public List<CatlogItem> getCatalog(@PathVariable("userID") String userID) {



        UserRatings ratings = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userID,
                UserRatings.class);

        return ratings.getUserRatings().stream().map(rating -> {
            //1): Hard coding is bad
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            return new CatlogItem(movie.getName(), "Desc", rating.getRating());
        }).collect(Collectors.toList());


    }

}



  /* WebClient
            Movie movie = webClientbuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
            */
