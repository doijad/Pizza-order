package com.cg.onlinepizza.customer.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.customer.controller.CustomerController;
import com.cg.onlinepizza.customer.dao.CustomerRepository;
import com.cg.onlinepizza.customer.entity.Customer;
import com.cg.onlinepizza.customer.exception.CustomerIdNotFoundException;

@Component
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository cRepo;

	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		return cRepo.save(customer);
	}
	
	@Override
	public List<Customer> viewCustomers() {
		List<Customer> clist= cRepo.findAll();
		return clist;
	}
    
	
	
	@Override
	@Transactional
	public Customer viewCustomer(int customerid) throws CustomerIdNotFoundException {
		Optional<Customer> cus = cRepo.findById(customerid);
		if(cus.isPresent())
			return cus.get();
		
		throw new CustomerIdNotFoundException("No found with id : "+customerid);
	}
    
	
	@Override
	@Transactional
	public Customer updateCustomer(Customer customer,int customerid) throws CustomerIdNotFoundException{
	
		Customer findcus = addCustomer(customer);
		findcus.setcId(customer.getcId());
		findcus.setcName(customer.getcName());
		findcus.setcMobileNo(customer.getcMobileNo());
		findcus.setcEmail(customer.getcEmail());
		findcus.setcAddress(customer.getcAddress());
		return cRepo.save(findcus);
	}
	
	
		
	

	
	@Override
	@Transactional
	public Customer deleteCustomer(int customerId) throws  CustomerIdNotFoundException{
		Optional<Customer>cust=cRepo.findById(customerId);
		Customer cus =null;
		if(cust.isPresent()) {
			cus=cust.get();
		   cRepo.delete(cus);
		}
		else {
			 throw new CustomerIdNotFoundException("Customer not found");
		}
		return cus;
	}

	public Object viewCustomer(Customer cus, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object updateCustomer(int cus, int customerid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

	

	
}
