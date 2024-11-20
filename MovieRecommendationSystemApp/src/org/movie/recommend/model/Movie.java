package org.movie.recommend.model;

public class Movie {
	
	private String movie_name;
	private String dateof_release;
	private String movie_budget;
	private int movie_id;

	public Movie() {

	}

	public Movie(String movie_name, String dateof_release, String movie_budget,int movie_id) {
		this.movie_name = movie_name;
		this.dateof_release = dateof_release;
		this.movie_budget = movie_budget;
		this.movie_id=movie_id;

	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}


	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getDateof_release() {
		return dateof_release;
	}

	public void setDateof_release(String dateof_release) {
		this.dateof_release = dateof_release;
	}

	public String getMovie_budget() {
		return movie_budget;
	}

	public void setMovie_budget(String movie_budget) {
		this.movie_budget = movie_budget;
	}

}
