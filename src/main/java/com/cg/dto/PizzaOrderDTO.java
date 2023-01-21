package com.cg.dto;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

public class PizzaOrderDTO {
	private int bookingOrderId;
	@Past
	private LocalDate dateOfOrder;
	@NotEmpty
	private String transactionMode;
	private int quantity;
	private String size;
	private double totalCost;
	
	public PizzaOrderDTO() {}
	public PizzaOrderDTO(int bookingOrderId, LocalDate dateOfOrder, String transactionMode, int quantity, String size,
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


	
	

}