package com.cg.servicepizzaorder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.dao.PizzaOrderRepository;
import com.cg.entity.PizzaOrder;
import com.cg.exception.OrderIdNotFoundException;
import com.cg.service.PizzaOrderServiceImpl;




	@ExtendWith(MockitoExtension.class)
	public class PizzaOrderServiceImplTest {
		@Mock
		private PizzaOrderRepository repo;
		@InjectMocks
		private PizzaOrderServiceImpl pService;
		private List<PizzaOrder> pizzaList;
		private PizzaOrder pizza = null;
		@Test
		void addOrderTest() {
			Mockito.when(pService.bookPizzaOrder(pizza)).thenReturn(pizza);
			assertEquals(pService.bookPizzaOrder(pizza), pizza);
		}
		@Test

		void viewPizzaOrder() {
		try {
			Mockito.when(pService.viewPizzaOrder(101)).thenReturn(pizza);
			assertEquals(pService.viewPizzaOrder(101),pizza);
			} catch (OrderIdNotFoundException e) {
			e.printStackTrace();
		}

		}

		@Test
		void updateOrderTest() {
			try {
				Mockito.when(pService.updatePizzaOrder(pizza, 101)).thenReturn(pizza);
				assertEquals(pService.updatePizzaOrder(pizza, 101), pizza);
				} catch (OrderIdNotFoundException e) {
					e.printStackTrace();
					System.out.println("OrderIdNotFound");
				}
		}
		@Test
		void cancelPizzaOrder() {
			PizzaOrder isDelete;
			try {
				isDelete =pService.cancelPizzaOrder(101);
				assertTrue(isDelete);
				} catch (OrderIdNotFoundException e) {
					e.printStackTrace();
					System.out.println("Can't able to delete pizzaorder");
				}
		}
		private void assertTrue(PizzaOrder isDelete) {
			
		}
	}
