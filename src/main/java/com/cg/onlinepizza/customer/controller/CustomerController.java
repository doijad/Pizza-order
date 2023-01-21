package com.cg.onlinepizza.customer.controller;

import java.util.List;
import java.util.Optional;

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

import com.cg.onlinepizza.customer.entity.Customer;
import com.cg.onlinepizza.customer.exception.CustomerIdNotFoundException;
import com.cg.onlinepizza.customer.service.CustomerService;
@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
    
	//https://localhost:8080/Customer/Customer
	@GetMapping("/cus")
	public ResponseEntity<List<Customer>> viewCustomers() {
		try {
			List<Customer> clist = cService.viewCustomers();
			if(clist.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(clist,HttpStatus.OK);
		}
		}catch(Exception e) {
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	 @PostMapping("/newcus")
		public ResponseEntity<Customer> createCustomer(@RequestBody Customer c1){
			try {
				Customer cus=cService.addCustomer(c1);
				return new ResponseEntity<>(cus,HttpStatus.CREATED);
			}catch(Exception e) {
				System.out.println(e);
				return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
				
				
			} 
			}
	 @GetMapping("/cusbyid/{id}")
	    public ResponseEntity<Customer>viewCustomer(@PathVariable("id")int id)throws CustomerIdNotFoundException{
	    	Customer cus =cService.viewCustomer(id);
	    	if(cus!=null) {
			       return new ResponseEntity<>(cus,HttpStatus.OK);
	    	}else {
	    		
	    	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			    //throw new NoSuchEmployeeFoundException ("no Employee found")
			}
	    			
	    	}
	    

	


	@PutMapping("/modifycus/{id}")
    public ResponseEntity<Customer>updateCustomer(@PathVariable("id")int id,@RequestBody Customer newCus) throws CustomerIdNotFoundException{
		try {
			return new ResponseEntity(cService.updateCustomer(newCus, id),HttpStatus.ACCEPTED);
		}catch(CustomerIdNotFoundException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    }
    

	@DeleteMapping("/deletecus/{id}")
    public ResponseEntity<String> deletecustomer(@PathVariable("id")int id)throws CustomerIdNotFoundException{
		try {
			
		    
		    	return new ResponseEntity(cService.deleteCustomer(id),HttpStatus.OK);
		  
		}catch(CustomerIdNotFoundException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
 
    
    }

	
	

	
	

	private Customer addCustomer(Customer c1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
	private Customer findCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

	

}
