package com.cg.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.PizzaOrderRepository;
import com.cg.entity.PizzaOrder;
import com.cg.exception.InvalidSizeException;
import com.cg.exception.OrderIdNotFoundException;



@Service
public  class PizzaOrderServiceImpl implements PizzaOrderService {
	@Autowired
	private PizzaOrderRepository pizzaorderrepo;

	@Override
	@Transactional
	public PizzaOrder bookPizzaOrder(PizzaOrder order) {
		return pizzaorderrepo.save(order);
	}

	@Override
	public PizzaOrder updatePizzaOrder(PizzaOrder order,int bookingOrderId) throws OrderIdNotFoundException {
		Optional<PizzaOrder> pFind = pizzaorderrepo.findById(bookingOrderId);
		if (pFind.isPresent()) { 
			return pizzaorderrepo.save(order);
			
		}
		else {
			throw new OrderIdNotFoundException("Order Id Not Found");
		}
	}

	@Override
	public PizzaOrder cancelPizzaOrder(int orderId) throws OrderIdNotFoundException {
		Optional<PizzaOrder> pFind = pizzaorderrepo.findById(orderId);
		PizzaOrder pizza=null;
		if (pFind.isPresent()) { 
			pizza = pFind.get();
			pizzaorderrepo.deleteById(orderId);	
		}
		else {
			throw new OrderIdNotFoundException("Order Id Not Found");
		}

		return pizza;
	}

	@Override
	public PizzaOrder viewPizzaOrder(int orderId) throws OrderIdNotFoundException {
		Optional<PizzaOrder> pFind = pizzaorderrepo.findById(orderId);
		if (pFind.isPresent()) { 
			return pFind.get();
		}
		else {
			throw new OrderIdNotFoundException("Order Id Not Found");
		}
	}

	@Override
	public List<PizzaOrder> caluculateTotal(String size, int quantity) throws InvalidSizeException {


		return null;
	}
}