package com.ecommerce.entity;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;


@Entity

public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name ="name",nullable=false)
	private String name;
	@Column(name ="brand",nullable=false)
	private String brand;
	
	@Column(name ="description")
	private String description;
	
	@Column(name ="price",nullable=false)
	private double price;
	
	@Column(name ="category")
	private String category;
	
	@Column(name ="stockQuantity",nullable=false )
	private int  stockQuantity;
	
	@Column(name ="release_date")
	private Date releaseDate;
	
	@Column(name ="product_available")
	private boolean productAvailable;
	
	@Column(name ="image_name")
	private String imageName;
	
	@Column(name ="image_type")
	private String imageType;
	
	
	
	@Lob
	private byte[] imageDate;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public Product(String name, String brand, String description, double price, String category, int stockQuantity,
			Date releaseDate, boolean productAvailable) {
		super();
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.category = category;
		this.stockQuantity = stockQuantity;
		this.releaseDate = releaseDate;
		this.productAvailable = productAvailable;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", description=" + description + ", price="
				+ price + ", category=" + category + ", quantity=" + stockQuantity + ", releaseDate=" + releaseDate
				+ ", productAvailable=" + productAvailable + ", imageName=" + imageName + ", imageType=" + imageType
				+ ", imageDate=" + Arrays.toString(imageDate) + "]";
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int quantity) {
		this.stockQuantity = quantity;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public boolean isProductAvailable() {
		return productAvailable;
	}
	public void setProductAvailable(boolean productAvailable) {
		this.productAvailable = productAvailable;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public byte[] getImageDate() {
		return imageDate;
	}
	public void setImageDate(byte[] imageDate) {
		this.imageDate = imageDate;
	}
	
	
	

}
