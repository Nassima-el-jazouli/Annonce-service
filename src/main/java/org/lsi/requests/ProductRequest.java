package org.lsi.requests;

import java.time.LocalDateTime;

public class ProductRequest {
	private String name;
	private double price;
	private String address;
	private String image;
	private String description;
	private LocalDateTime dateTime;
	private boolean validation = false;
	private boolean vendu = false;
	public ProductRequest(String name, double price, String address, String image, String description,
			LocalDateTime dateTime, boolean validation, boolean vendu) {
		super();
		this.name = name;
		this.price = price;
		this.address = address;
		this.image = image;
		this.description = description;
		this.dateTime = dateTime;
		this.validation = validation;
		this.vendu = vendu;
	}
	public ProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductRequest [name=" + name + ", price=" + price + ", address=" + address + ", image=" + image
				+ ", description=" + description + ", dateTime=" + dateTime + ", validation=" + validation + ", vendu="
				+ vendu + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public boolean isValidation() {
		return validation;
	}
	public void setValidation(boolean validation) {
		this.validation = validation;
	}
	public boolean isVendu() {
		return vendu;
	}
	public void setVendu(boolean vendu) {
		this.vendu = vendu;
	}
	
	
}
