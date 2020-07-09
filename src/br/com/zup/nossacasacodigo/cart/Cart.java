package br.com.zup.nossacasacodigo.cart;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import br.com.zup.nossacasacodigo.book.Book;
import br.com.zup.nossacasacodigo.purchase.DiscountCoupon;

public class Cart {
	private Set<CartItem> items = new HashSet<>();
	Optional<DiscountCoupon> coupon;

	public void addToCart(Book book, int quantity) {
		if (quantity <= 0 || book == null) {
			throw new IllegalArgumentException("Livro ou quantidade inválida");
		}
		Optional<CartItem> alreadyInCart = checkIfIsInCart(book);
		CartItem item;
		if (alreadyInCart.isPresent()) {
			item = alreadyInCart.get();
			//realizamos a subtração do valor previamente existente desse item do carrinho para depois poder adicionar somente o valor atual dos n elementos presentes no carrinho
			item.setQuantity(item.getQuantity() + quantity);
		} else {
			item = new CartItem(book, quantity);
			items.add(item);
		}
	}

	private Optional<CartItem> checkIfIsInCart(Book book) {
		for (CartItem cartItem : items) {
			if (book.equals(cartItem.getBook())) {
				return Optional.ofNullable(cartItem);
			}
		}
		return Optional.empty();
	}

	public BigDecimal calculateFinalValue() {
		BigDecimal finalValue = BigDecimal.ZERO;
		for (CartItem cartItem : items) {
			finalValue = finalValue.add(cartItem.calculateSubtotal());
		}
		if(coupon != null && coupon.isPresent()) {
			finalValue = finalValue.subtract(finalValue.multiply(coupon.get().getDiscount()));
		}
		return finalValue;
	}
	
	public Set<CartItem> getCartItems() {
		return items;
	}

}
