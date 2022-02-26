package org.lsi.entities;

import java.time.LocalDateTime;
import java.util.Date;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "Product")
public class Product {
	@Id
	private String id;
	private String name;
	private double price;
	private String address;
	private String image;
	private String description;
	private LocalDateTime dateTime;
	private boolean validation = false;
	private boolean vendu = false;
	@DBRef
	private Category category;
	
	public Product(String name, double price, String address, String image, String description, LocalDateTime dateTime,
			boolean validation, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.address = address;
		this.image = image;
		this.description = description;
		this.dateTime = dateTime;
		this.validation = validation;
		this.category = category;
	}
	
	
	
}
