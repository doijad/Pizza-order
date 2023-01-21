package com.cg.onlinepizza.customer.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizza.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
   
	@Query("Select c from Customer c where c.cId=:cId")
	public Customer deleteCustomer(@Param("cId") int cId);

	public Customer addCustomer(int cus);

	public Customer addCustomer(Customer cus);
	
	
	
	

	

	
	
}

