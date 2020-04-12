package model;

public class Ratings {

	private String movieId;

	public Ratings() {
		super();
	}

	private int rating;

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Ratings(String movieId, int rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}

}