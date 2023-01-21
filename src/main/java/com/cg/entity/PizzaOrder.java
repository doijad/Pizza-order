package com.cg.entity;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="pizzaordertable")
public class PizzaOrder {
	@Id
	private int bookingOrderId;
	private LocalDate dateOfOrder;
	private String transactionMode;
	private int quantity;
	private String size;
	private double totalCost;
	
	public PizzaOrder(int bookingOrderId, LocalDate dateOfOrder, String transactionMode, int quantity, String size,
			double totalCost) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.dateOfOrder = dateOfOrder;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.size = size;
		this.totalCost = totalCost;
	}
	public int getBookingOrderId() {
		return bookingOrderId;
	}
	public void setBookingOrderId(int bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}
	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "PizzaOrder [bookingOrderId=" + bookingOrderId + ", dateOfOrder=" + dateOfOrder + ", transactionMode="
				+ transactionMode + ", quantity=" + quantity + ", size=" + size + ", totalCost=" + totalCost + "]";
	}
	
	

}


