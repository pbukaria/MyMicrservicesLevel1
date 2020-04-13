package com.codeintground.moviecatalogservice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.model.CatalogModelItem;
import com.model.Movies;
import com.model.Ratings;
import com.model.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	// Using Rest Template, Now it is depricated.
	@Autowired
	private RestTemplate template;

	// Using WebClientBuilder
	@Autowired
	private WebClient.Builder webclientbuilder;

	@RequestMapping("/{userId}")
	public List<CatalogModelItem> getCatalogList(@PathVariable("userId") String userId) {
		// Instead of this I have created a bean in main class of same type to use same
		// instance of this template everytime
		// RestTemplate template = new RestTemplate();

		UserRatings ratings = template.getForObject("http://ratings-service/ratingsdata/users/"+ userId, UserRatings.class);

		return ratings.getUserRatings().stream().map(rating -> {
			//Using RestTemplate
			Movies movies = template.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movies.class);

			/* Using WebClient
			Movies movies = webclientbuilder.build().get().uri("http://localhost:8082/movies/" + rating.getMovieId()).retrieve()
					.bodyToMono(Movies.class).block();
			End WebClient*/

			return new CatalogModelItem(movies.getMoviename(), "desc", rating.getRating());
		}).collect(Collectors.toList());

	}

}
