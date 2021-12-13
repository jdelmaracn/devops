package com.accenture.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	public int order_id;
	
	
	@Column(name = "order_name")
	public String order_name;
	@Column(name = "price")
	public double price;
	@Column(name = "is_discounted")
	public boolean is_discounted;
	@Column(name = "discount_percentage")
	public double discount_percentage = 5.0;
	
	public order() {}

	public order(int order_id, String order_name, double price, boolean is_discounted, int discount_percentage) {
		this.order_id = order_id;
		this.order_name = order_name;
		this.price = price;
		this.is_discounted = is_discounted;
		this.discount_percentage = discount_percentage;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isIs_discounted() {
		return is_discounted;
	}

	public void setIs_discounted(boolean is_discounted) {
		this.is_discounted = is_discounted;
	}

	public double getDiscount_percentage() {
		return discount_percentage;
	}

	public void setDiscount_percentage(int discount_percentage) {
		this.discount_percentage = discount_percentage;
	}
	
}
