package com.cg.onlinepizza.coupon.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.cg.onlinepizza.controller.CouponController;
import com.cg.onlinepizza.coupon.dao.CouponRepository;
import com.cg.onlinepizza.coupon.entity.Coupon;
import com.cg.onlinepizza.coupon.exception.CouponIdNotFoundException;
import com.cg.onlinepizza.coupon.exception.InvalidCouponOperationException;
import com.cg.onlinepizza.coupon.service.CouponService_Impl;

@ExtendWith(MockitoExtension.class)
public class CouponControllerTest {

	@Mock
	private CouponRepository repo;

	@InjectMocks
	private CouponController cont;

	private ResponseEntity<List<Coupon>> list;
	private ResponseEntity<Coupon> cp = null;

	@Test
	public void addCouponTest() {
		Mockito.when(repo.addCoupons(cp)).thenReturn(cp);
		assertEquals(cont.addCoupons(cp), cp);
		verify(repo, Mockito.times(1)).save(cp);
	}

	@Test
	public void viewCouponstTest() {
		Mockito.when(cont.viewCoupons()).thenReturn(list);
		assertEquals(cont.viewCoupons(), list);

	}

	@Test
	void editCouponTest() throws InvalidCouponOperationException {
		try {
			Mockito.when(cont.editCoupon(cp, 101)).thenReturn(cp);
			assertEquals(cont.editCoupon(cp, 101), cp);
		} catch (InvalidCouponOperationException e) {
			e.printStackTrace();
			System.out.println("Invalid Coupon operation, Couldn't edit coupon ");
		}

	}

	@Test
	void deleteCouponTest() {
		boolean isDelete;
		try {
			isDelete = cont.deleteCoupon(101);
			assertTrue(isDelete);
		} catch (CouponIdNotFoundException e) {
			e.printStackTrace();
			System.out.println("Can't able to delete Coupon");
		}

	}
}
