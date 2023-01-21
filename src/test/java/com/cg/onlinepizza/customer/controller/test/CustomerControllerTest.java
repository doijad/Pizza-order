package com.cg.onlinepizza.customer.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.cg.onlinepizza.customer.controller.CustomerController;
import com.cg.onlinepizza.customer.dao.CustomerRepository;
import com.cg.onlinepizza.customer.entity.Customer;
import com.cg.onlinepizza.customer.exception.CustomerIdNotFoundException;
import com.cg.onlinepizza.customer.exception.InvalidCustomerException;
import com.cg.onlinepizza.customer.service.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
	@SuppressWarnings("unused")
	private static final Customer CustomerList=null;
	
	@Mock
   private CustomerRepository cRepo;
   
	@InjectMocks
   private CustomerController cont;
	@SuppressWarnings("unused")
	private List<Customer> cList;
	private int cus = (Integer) null;

	 private void CustomerController() {
			cont=new CustomerController();
	        cList=new ArrayList<>();
		}
	
	@Test

	public void viewCustomersTest() {
    Mockito.when(cont.viewCustomers()).thenReturn( cList);
    assertEquals(cont.viewCustomers(), cList);
    
    }
    
	@Test
	void tstaddCustomer() {
		Mockito.when(cRepo.addCustomer(cus)).thenReturn(cus);
		assertEquals(cRepo.addCustomer(cus),cus);
		verify(cRepo, Mockito.times(1)).save(cus);
		}
	
	@Test
    void viewCustomerTest() throws CustomerIdNotFoundException{
    com.cg.onlinepizza.customer.entity.Customer isPresent;
    try {
    isPresent =cont.viewCustomer(504);
    assertTrue(isPresent);
    } catch (CustomerIdNotFoundException e) {
    e.printStackTrace();
    System.out.println("customers are Can't able to view");
    }
    }
	 
	@Test
	void updateCustomerTest() throws CustomerIdNotFoundException {
		try {
    Mockito.when(cont.updateCustomer(cus, 504)).thenReturn(cus);
    assertEquals(cont.updateCustomer(cus, 504), cus);
    } catch (CustomerIdNotFoundException e) {
    e.printStackTrace();
    System.out.println("Invalid Customer details, Couldn't edit customer ");
    }
    }

	@Test
    void deleteCustomerTest() throws CustomerIdNotFoundException{
    com.cg.onlinepizza.customer.entity.Customer isDelete;
    try {
    isDelete =cont.deleteCustomer(504);
    assertTrue(isDelete);
    } catch (CustomerIdNotFoundException e) {
    e.printStackTrace();
    System.out.println("Can't able to delete Customer");
    }
	}
	private void assertTrue(Customer isDelete) {
		// TODO Auto-generated method stub
		
	}
	
	  
   
	

}
