package br.com.zup.nossacasacodigo.cart;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DiscountCoupon {
	private String discountCode;
	private LocalDateTime createdAt;
	private LocalDateTime expirationDate;
	private BigDecimal discount;
	
	public DiscountCoupon(String discountCode, LocalDateTime expirationDate, BigDecimal discount) {
		this.discountCode =  discountCode;
		this.createdAt = LocalDateTime.now();
		this.expirationDate = expirationDate;
		this.discount = discount;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public BigDecimal getDiscount() {
		return discount;
	}
	
}
