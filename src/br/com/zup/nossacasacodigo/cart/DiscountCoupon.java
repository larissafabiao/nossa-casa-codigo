package br.com.zup.nossacasacodigo.cart;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zup.nossacasacodigo.auxiliars.Validators;

public class DiscountCoupon {
	private String discountCode;
	private LocalDateTime createdAt;
	private LocalDateTime expirationDate;
	private BigDecimal discount;
	
	public DiscountCoupon(String discountCode, LocalDateTime expirationDate, BigDecimal discount) {
		this.discountCode = Validators.checkNull(discountCode, "Código de desconto");
		this.createdAt = LocalDateTime.now();
		this.expirationDate = expirationDateValidator(expirationDate, createdAt);
		Validators.checkNull(discount.toString(), "valor do desconto");
		this.discount = discountValidator(discount);
	}

	private LocalDateTime expirationDateValidator(LocalDateTime expiration, LocalDateTime created) {
		if(expiration.isBefore(created) || expiration.isEqual(created)) {
			throw new IllegalArgumentException("A data de expiração do cupon precisa ser poserior a de criação");
		}
		return null;
	}
	
	private BigDecimal discountValidator(BigDecimal discount) {
		if(discount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("O valor do desconto deve ser uma porcentagem maior do que 0");
		}
		return discount;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public BigDecimal getDiscount() {
		return discount;
	}
	
}
