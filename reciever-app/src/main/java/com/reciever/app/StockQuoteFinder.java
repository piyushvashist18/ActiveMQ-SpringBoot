package com.reciever.app;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sender.app.MovieInfo;

@RestController
public class StockQuoteFinder {
	@Autowired
	AppService service;
	@Autowired
	JmsTemplate jmsTemplate;
	List<Movies> movies = new ArrayList<>();
	@JmsListener(destination="StockQueue",containerFactory="stockFactory")
	public void receiveMessage(String symbol) {
		double price = Math.random() * 1000;
		System.out.println("Price of " + symbol + ": " + price);
	}
	
	@JmsListener(destination="StockQueue",containerFactory="stockFactory")
	public void receiveMessage1(String symbol) {
		double price = Math.random() * 1000;
		System.out.println("receiveMessage1 Price of " + symbol + ": " + price);
	}
	
	@JmsListener(destination="MovieInfo",containerFactory="stockFactory")
	public void receiveMovieMessage(Message message) throws JMSException, URISyntaxException {
		ObjectMessage mapMessage = (ObjectMessage) message;
		System.out.println(mapMessage.getObject());
		MovieInfo m = (MovieInfo) mapMessage.getObject();
		System.out.println(m.getMovieName());
		ResponseEntity<Movies> res = service.get(m.getMovieName(), m.getYear());
		System.out.println(res.getBody().getTitle());
		movies.add(res.getBody());
		jmsTemplate.convertAndSend("MoviesResult",Movies.class);
	}
	
	@GetMapping("/result")
	public List<Movies> movies(){
		return movies;
	}
}
