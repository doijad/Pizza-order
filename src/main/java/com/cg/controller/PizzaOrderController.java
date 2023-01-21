package com.cg.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.PizzaOrder;
import com.cg.exception.OrderIdNotFoundException;
import com.cg.service.PizzaOrderService;



@RestController
public class PizzaOrderController {
	@Autowired
	private PizzaOrderService pService;
	
	@PostMapping("/bookorder")
	public ResponseEntity<PizzaOrder> bookPizzaOrder(@RequestBody PizzaOrder pOrder){
		try {
			PizzaOrder pizza = pService.bookPizzaOrder(pOrder);
				return new ResponseEntity<>(pizza,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/orderbyid/{id}")
	public ResponseEntity<PizzaOrder> findPizzaOrderById(@PathVariable("id")int id) throws OrderIdNotFoundException {
		PizzaOrder pizzaOrder = pService.viewPizzaOrder(id);
		if(pizzaOrder!=null) {
			return new ResponseEntity<>(pizzaOrder,HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/modifyorder/{id}")
	public ResponseEntity<PizzaOrder> updatePizzaOrder(@RequestBody PizzaOrder order, @PathVariable("id")int id){
		try {
			return new ResponseEntity<>(pService.updatePizzaOrder(order, id),HttpStatus.ACCEPTED);
			
		}
		catch(OrderIdNotFoundException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);

		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteorder/{id}")
	public ResponseEntity<String> deletePizzaOrder(@PathVariable("id")int id){
		try {
				return new ResponseEntity(pService.cancelPizzaOrder(id),HttpStatus.OK);
			}
		catch(OrderIdNotFoundException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);

		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	


}
