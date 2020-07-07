package br.com.zup.nossacasacodigo.cart;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import br.com.zup.nossacasacodigo.book.Book;

public class Cart {
	private Set<CartItem> items = new HashSet<>();
	private static BigDecimal finalValue = BigDecimal.ZERO;

	public void addToCart(Book book, int quantity) {
		if (quantity < 0 || book == null) {
			throw new IllegalArgumentException("Livro ou quantidade inválida");
		}
		Optional<CartItem> alreadyInCart = checkIfIsInCart(book);
		CartItem item;
		if (alreadyInCart.isPresent()) {
			item = alreadyInCart.get();
			//realizamos a subtração do valor previamente existente desse item do carrinho para depois poder adicionar somente o valor atual dos n elementos presentes no carrinho
			finalValue = finalValue.subtract(item.calculateSubtotal());
			item.setQuantity(item.getQuantity() + quantity);
			finalValue = finalValue.add(item.calculateSubtotal());
		} else {
			item = new CartItem(book, quantity);
			items.add(item);
			finalValue = finalValue.add(item.calculateSubtotal());
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

	public BigDecimal getFinalValue() {
		return finalValue;
	}

	public Set<CartItem> getCart() {
		return items;
	}
}
