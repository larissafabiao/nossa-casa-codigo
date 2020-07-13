package br.com.zup.nossacasacodigo.purchase;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.zup.nossacasacodigo.cart.Cart;
import br.com.zup.nossacasacodigo.cart.CartItem;

public class Purchase {
	private Cart cart;
	private DiscountCoupon coupon;
	int id;
	
	public Purchase(Cart cart, int id) {
		this.cart = cart;
		this.id = id;
	}
	
	public BigDecimal calculateFinalValue() {
		BigDecimal finalValue = BigDecimal.ZERO;
		for (CartItem cartItem : cart.getCartItems()) {
			finalValue = finalValue.add(cartItem.calculateSubtotal());
		}
		if(coupon != null) {
			finalValue = finalValue.subtract(finalValue.multiply(coupon.getDiscount()));
		}
		return finalValue;
	}
	
	public void addDiscountCoupon(Optional<DiscountCoupon> discount) {
		if(discount.isPresent()) {
			this.coupon = discount.get();
		}

	}
}
