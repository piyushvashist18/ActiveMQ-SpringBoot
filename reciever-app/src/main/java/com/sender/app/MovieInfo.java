package com.sender.app;

import java.io.Serializable;

public class MovieInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2491928530110436008L;
	
	private String movieName;
	private long year;
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	
	
}
