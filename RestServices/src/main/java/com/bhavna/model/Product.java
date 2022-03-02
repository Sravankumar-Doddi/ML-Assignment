package com.bhavna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer productId;

	@Column(name = "NAME")
	private String productName;

	@Column(name = "PRICE")
	private Integer price;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", category="
				+ category + "]";
	}

}
