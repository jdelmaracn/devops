package com.accenture.ws.entity;

public class OrderBill {
	order[] orderList;
	cafeClerk cafeClerk;
	
	public OrderBill(com.accenture.ws.entity.cafeClerk cafeClerk) {
		this.cafeClerk = cafeClerk;
	}

	public order[] getOrderList() {
		return orderList;
	}

	public void setOrderList(order[] orderList) {
		this.orderList = orderList;
	}

	public cafeClerk getCafeClerk() {
		return cafeClerk;
	}
	
	public double getTotalBill() {
		double total = 0;
		for(int x = 0 ; x < this.orderList.length ; x ++) {
			total += (this.orderList[x].isIs_discounted()) ? this.orderList[x].getPrice() - (this.orderList[x].getPrice() / 0.05):this.orderList[x].getPrice();
		}
		return total;
	}
	
	
	
}
