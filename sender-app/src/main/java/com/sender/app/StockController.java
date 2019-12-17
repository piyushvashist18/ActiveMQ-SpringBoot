package com.sender.app;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

	@Autowired
	JmsTemplate jmsTemplate;
	@GetMapping("/api/v1/stock/{symbol}")
	public void get(@PathVariable("symbol") String symbol){
		jmsTemplate.convertAndSend("StockQueue",symbol);
	}
	
	@GetMapping("/info/{movieName}/{year}")
	public void info(@PathVariable("movieName") String movieName,@PathVariable("year") long year){
		MovieInfo info = new MovieInfo();
		info.setMovieName(movieName);
		info.setYear(year);

		jmsTemplate.convertAndSend("MovieInfo",info);
		
	}
}
