package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRpository;
import com.educandoweb.course.repositories.OrderRpository;
import com.educandoweb.course.repositories.ProductRpository;
import com.educandoweb.course.repositories.UserRpository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRpository userRpository;
	
	@Autowired
	private OrderRpository orderRpository;
	
	@Autowired
	private CategoryRpository categoryRpository;
	
	@Autowired
	private ProductRpository productRpository;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRpository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRpository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Dhakson Barbosa", "dhakson18@gmail.com", "966666666","123456" );
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-06-21T19:53:07z"),OrderStatus.WAITING_PAYMENT, u1);
		Order o3 = new Order(null, Instant.parse("2019-06-22T19:53:07z"),OrderStatus.WAITING_PAYMENT, u3);
		
		userRpository.saveAll(Arrays.asList(u1,u2,u3));
		orderRpository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
	
	

}
