package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRpository;
import com.educandoweb.course.repositories.UserRpository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRpository userRpository;
	
	@Autowired
	private OrderRpository orderRpository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Dhakson Barbosa", "dhakson18@gmail.com", "966666666","123456" );
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-06-21T19:53:07z"), u1);
		Order o3 = new Order(null, Instant.parse("2019-06-22T19:53:07z"), u3);
		
		userRpository.saveAll(Arrays.asList(u1,u2,u3));
		orderRpository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
	
	

}
