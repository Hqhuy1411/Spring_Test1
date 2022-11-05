package com.DemoSpring.DTO;

import javax.persistence.Transient;

public class ProductDTO {
	private int id;
	private String name;
	private String imageUrl;
	private Long price;
	private String categoryName;
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Transient
	public String getImagePath() {
		if(imageUrl == null || id == 0) {
			return null;
		}
		return "/images/" + imageUrl;
		
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", price=" + price
				+ ", categoryName=" + categoryName + "]";
	}
	
}
