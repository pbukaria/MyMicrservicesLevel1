package com.codeintground.ratingsdataservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Ratings;
import model.UserRatings;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {

	@RequestMapping("/{movieId}")
	public Ratings getRatings(@PathVariable("movieId") String movieId) {
		return new Ratings(movieId, 4);

	}

	@RequestMapping("users/{userId}")
	public UserRatings getuserRating(@PathVariable("userId") String userId) {
		List<Ratings> ratings = Arrays.asList(new Ratings("1234", 4), new Ratings("5678", 5));

		UserRatings userRating = new UserRatings();
		userRating.setUserRatings(ratings);
		return userRating;
	}

}
