package br.com.zup.nossacasacodigo.purchase;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiscountCouponTest {	
	@Test
	public void testCreatingACorrectCouponReturningASucess() {
		LocalDateTime expirationDate = LocalDateTime.of(2020, 10, 1, 23, 59);
		String name = "LESS10";
		BigDecimal value = new BigDecimal("0.1");
		DiscountCoupon less10 = new DiscountCoupon(name, expirationDate,value);
	}
	
	@Test
	public void testCreatingACouponWithAnInvalidExpirationDateReturningException() {
		LocalDateTime expirationDate = LocalDateTime.now();
		String name = "LESS10";
		BigDecimal value = new BigDecimal("0.1");
		Assertions.assertThrows(IllegalArgumentException.class, () -> new DiscountCoupon(name, expirationDate,value));
	}
	
	@Test
	public void testCreatingACouponWithAnInvalidValueReturningException() {
		LocalDateTime expirationDate = LocalDateTime.now();
		String name = "LESS10";
		BigDecimal value = new BigDecimal("0.0");
		Assertions.assertThrows(IllegalArgumentException.class, () -> new DiscountCoupon(name, expirationDate,value));
	}
	
	@Test
	public void testCreatingACouponWithAnInvalidNameReturningException() {
		LocalDateTime expirationDate = LocalDateTime.now();
		String name = "";
		BigDecimal value = new BigDecimal("0.1");
		Assertions.assertThrows(IllegalArgumentException.class, () -> new DiscountCoupon(name, expirationDate,value));
	}
	
	@Test
	public void testCreatingACouponWithANullNameReturningException() {
		LocalDateTime expirationDate = LocalDateTime.now();
		String name = null;
		BigDecimal value = new BigDecimal("0.1");
		Assertions.assertThrows(IllegalArgumentException.class, () -> new DiscountCoupon(name, expirationDate,value));
	}
}
