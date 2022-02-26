package org.lsi;

import java.util.ArrayList;
import java.util.stream.Stream;
import org.lsi.entities.Category;
import org.lsi.entities.Product;
import org.lsi.repositories.CategoryRepository;
import org.lsi.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//(scanBasePackages= {
//		"org.lsi.entities",
//		"org.lsi.repositories",
//		"org.lsi.controllers",
//		"org.lsi.exception",
//		"org.lsi.web"})

@EnableDiscoveryClient
@EnableFeignClients(basePackages ="org.lsi.feign")
public class AnnonceServiceApplication {
	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(AnnonceServiceApplication.class, args);
	}
	
	/*CommandLineRunner start(CategoryRepository categoryRepository, ProductRepository productRepository) {
		return args->{
			categoryRepository.deleteAll();
			Stream.of("C1 Villa", "C2 Appartement").forEach(c->{
				categoryRepository.save(new Category(c.split(" ")[0], c.split(" ")[1], new ArrayList<>()));
			});
			categoryRepository.findAll().forEach(System.out::println);
			
			
			productRepository.deleteAll();
			Category c1 = categoryRepository.findById("C1").get();
			Stream.of("P1", "P2", "P3", "P4").forEach(name->{
				productRepository.save(new Product(null, name, Math.random()*1000, "hey1", "hey1", c1));
			});
			
			Category c2 = categoryRepository.findById("C2").get();
			Stream.of("P5", "P6", "P7", "P8").forEach(name->{
				productRepository.save(new Product(null, name, Math.random()*1000, "hey2", "hey2", c2));
			});
			
			productRepository.findAll().forEach(System.out::println);
			
		};
	}*/
}
