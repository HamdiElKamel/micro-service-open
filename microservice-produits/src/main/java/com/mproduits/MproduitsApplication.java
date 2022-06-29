package com.mproduits;

import com.mproduits.dao.ProductDao;
import com.mproduits.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class MproduitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MproduitsApplication.class, args);
	}
@Bean
	CommandLineRunner start(ProductDao productDao)
{
	int i=1;
	return ar->{
		Stream.of("p1","p2","p3").forEach(p->{

			productDao.save(new Product(0, p, "description", "https://cours-informatique-gratuit.fr/wp-content/uploads/2014/05/clavier-1-1200x485.jpg", 10+Math.random()*500));


		});
		productDao.findAll().forEach(System.out::println);
	};


}

}
