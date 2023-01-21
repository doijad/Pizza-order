package com.cg.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.PizzaOrder;



@Repository
public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Integer>{

}

