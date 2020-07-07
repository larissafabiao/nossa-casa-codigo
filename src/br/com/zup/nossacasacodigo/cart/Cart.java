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
			throw new IllegalArgumentException("Livro ou quantidade inv�lida");
		}
		Optional<CartItem> alreadyInCart = checkIfIsInCart(book);
		CartItem item;
		if (alreadyInCart.isPresent()) {
			item = alreadyInCart.get();
			//realizamos a subtra��o do valor previamente existente desse item do carrinho para depois poder adicionar somente o valor atual dos n elementos presentes no carrinho
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

	public BigDecimal getFinalValue() {
		for (CartItem cartItem : items) {
			finalValue = finalValue.add(cartItem.calculateSubtotal());
		}
		return finalValue;
	}

	public void setFinalValue(BigDecimal newValue) {
		finalValue = newValue;
	}
	public Set<CartItem> getCart() {
		return items;
	}
}
