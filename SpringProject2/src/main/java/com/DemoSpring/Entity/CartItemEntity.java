package com.DemoSpring.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cartitems")
public class CartItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity productEntity;
	@Column
	private int quantily;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ProductEntity getProduct() {
		return productEntity;
	}
	public void setProduct(ProductEntity product) {
		this.productEntity = product;
	}
	public int getQuantily() {
		return quantily;
	}
	public void setQuantily(int quantily) {
		this.quantily = quantily;
	}
	
}
