package br.com.zup.nossacasacodigo.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import br.com.zup.nossacasacodigo.book.Book;

public class Cart {
	private List<Book> items = new ArrayList<Book>();
	private static BigDecimal finalValue = new BigDecimal("0.0");

	public  void addToCart(Book book) {
		items.add(book);
		finalValue = finalValue.add(book.getPrice());
	}

	public BigDecimal getFinalValue() {
		return finalValue;
	}

	public List<Book> getCart() {
		return items;
	}
}
