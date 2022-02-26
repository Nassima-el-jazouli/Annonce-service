package org.lsi.repositories;

import java.util.List;

import org.lsi.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends MongoRepository<Product, String>{
	
	List<Product> findAllById(String id);
}
