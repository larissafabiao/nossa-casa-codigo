package br.com.zup.nossacasacodigo.cart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import br.com.zup.nossacasacodigo.book.Book;

public class Cart {
	private Set<CartItem> items = new HashSet<>();
	private static BigDecimal finalValue = BigDecimal.ZERO;

	public void addToCart(Book book, int quantity) {
		Optional<CartItem> alreadyInCart = checkIfIsInCart(book);
		if (alreadyInCart.isPresent()) {
			CartItem item = alreadyInCart.get();
			item.setQuantity(item.getQuantity()+ quantity);
		} else {
			CartItem newItem = new CartItem(book, quantity);
			items.add(newItem);
		}
	
		finalValue = finalValue.add(book.getPrice().multiply(new BigDecimal(quantity)));
	}

	private Optional<CartItem> checkIfIsInCart(Book book) {
		for (CartItem cartItem : items) {
			if (cartItem.getBook() == book) {
				return Optional.ofNullable(cartItem);
			}
		}
		return Optional.empty();
	}

	public BigDecimal getFinalValue() {
		return finalValue;
	}

	public Set<CartItem> getCart() {
		return items;
	}
}
