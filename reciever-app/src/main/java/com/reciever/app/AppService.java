package com.reciever.app;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AppService {

	@Autowired
	RestTemplate restTemplate;
	
	public ResponseEntity<Movies> get(String title,Long year) throws URISyntaxException{
		 final String baseUrl = "http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f&t="+title+"&y="+year;
		  //  URI uri = new URI(baseUrl);
		    return restTemplate.getForEntity(baseUrl, Movies.class);
		    
	}
}
