package br.com.zup.nossacasacodigo.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.zup.nossacasacodigo.book.Book;
import br.com.zup.nossacasacodigo.database.Database;

public class Cart {
	private List<Book> cart = new ArrayList<Book>();
	private static BigDecimal finalValue = new BigDecimal("0.0");
	
	public  void addToCart(String wanted, Database db) {
		Optional<Book> bookReturned = db.seachBook(wanted);
		if (bookReturned.isPresent()) {
			Book book = bookReturned.get();
			cart.add(book);
			finalValue = finalValue.add(book.getPrice());
		} else {
			System.out.println("Livro não encontrado");
		}
	}
	
	public BigDecimal getFinalValue() {
		return finalValue;
	}
	
	public List<Book> getCart() {
		return cart;
	}
}
