package com.codeintground.movieinfoservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Movies;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@RequestMapping("/{movieId}")
	public Movies getMovies(@PathVariable ("movieId") String movieId){
		return new Movies(movieId, "Test name")	;
	}

}
