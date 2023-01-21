package com.cg.service;
import java.util.List;

import com.cg.entity.PizzaOrder;
import com.cg.exception.InvalidSizeException;
import com.cg.exception.OrderIdNotFoundException;




public interface PizzaOrderService {
	PizzaOrder bookPizzaOrder(PizzaOrder order);

	PizzaOrder updatePizzaOrder(PizzaOrder order,int bookingOrderId)throws OrderIdNotFoundException;
	
	PizzaOrder cancelPizzaOrder(int orderId) throws OrderIdNotFoundException;

	PizzaOrder viewPizzaOrder(int orderId) throws OrderIdNotFoundException;

	List<PizzaOrder> caluculateTotal(String size, int quantity) throws InvalidSizeException;

}