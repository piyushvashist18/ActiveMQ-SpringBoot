package com.reciever.app;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movies implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8286634567393765561L;


	@JsonProperty("Title")
	private String title;
	
	
	@JsonProperty("Rated")
	private String rated;
	
	@JsonProperty("Actors")
	private String actors;

	@JsonProperty("Director")
	private String directors;
	
	@JsonProperty("Year")
	private String year;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
