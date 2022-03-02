package com.bhavna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer orderId;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	@Column(name = "QUANTITY")
	private Integer quantity;

	@Column(name = "PRICE")
	private Integer orderPrice;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Integer orderPrice) {
		this.orderPrice = orderPrice;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", product=" + product + ", quantity=" + quantity + ", orderPrice="
				+ orderPrice + "]";
	}

}