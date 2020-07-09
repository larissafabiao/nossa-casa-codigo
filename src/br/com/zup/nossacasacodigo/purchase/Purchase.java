package br.com.zup.nossacasacodigo.purchase;

import java.math.BigDecimal;

import br.com.zup.nossacasacodigo.cart.Cart;
import br.com.zup.nossacasacodigo.cart.CartItem;

public class Purchase {
	Cart cart;
	DiscountCoupon coupon;
	int id;
	
	public Purchase(Cart cart, DiscountCoupon coupon, int id) {
		this.cart = cart;
		this.coupon = coupon;
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
	
}
