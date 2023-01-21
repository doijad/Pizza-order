package com.cg.onlinepizza.customer.service;

import java.util.List;



import com.cg.onlinepizza.customer.entity.Customer;
import com.cg.onlinepizza.customer.exception.CustomerIdNotFoundException;


public interface CustomerService {
	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer customer,int customerId)throws CustomerIdNotFoundException;

    Customer deleteCustomer(int customerId) throws CustomerIdNotFoundException;

	List<Customer> viewCustomers();

	Customer viewCustomer(int customerId) throws CustomerIdNotFoundException;

	

	

	

	

	


}
