package br.com.zup.nossacasacodigo.cart;

import java.math.BigDecimal;

import br.com.zup.nossacasacodigo.book.Book;

public class CartItem {
	private Book book;
	private int quantity;
	
	public CartItem(Book book, int quantity) {
		this.book = book;
		this.setQuantity(quantity);
	}
	
	public BigDecimal calculateSubtotal() {
		return book.getPrice().multiply(new BigDecimal(quantity));
	}
	
	public Book getBook() {
		return book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
