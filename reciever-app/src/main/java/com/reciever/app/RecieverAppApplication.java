package com.reciever.app;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJms
public class RecieverAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecieverAppApplication.class, args);
	}
	
	@Bean
	  public JmsListenerContainerFactory<?> stockFactory(
	      ConnectionFactory connectionFactory,
	      DefaultJmsListenerContainerFactoryConfigurer configurer) {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

	    configurer.configure(factory, connectionFactory);
	    return factory;
	  }
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
	    ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
	    factory.setTrustedPackages(Arrays.asList("com.sender.app"));
	    return factory;
	}
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
