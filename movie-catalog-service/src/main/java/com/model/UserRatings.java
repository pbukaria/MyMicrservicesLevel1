package com.model;

import java.util.List;

public class UserRatings {

	private List<Ratings> userRatings;

	public UserRatings(List<Ratings> userRatings) {
		super();
		this.userRatings = userRatings;
	}

	public UserRatings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Ratings> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Ratings> userRatings) {
		this.userRatings = userRatings;
	}
}
