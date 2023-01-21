package com.cg.onlinepizza.pizza.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizza.pizza.entity.Pizza;

@Repository
public interface PizzaRepo extends JpaRepository<Pizza, Integer>{

}
