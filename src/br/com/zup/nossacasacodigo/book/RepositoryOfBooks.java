package br.com.zup.nossacasacodigo.book;

import java.util.HashMap;
import java.util.Map;

public class RepositoryOfBooks {
	private Map<String, Book> books = new HashMap<String, Book>();
	
	public Map<String, Book> addBookInDatabase(Book book) {
		isbnIsUnic(book.getIsbn());
		books.put(book.getIsbn(), book);
		
		return books;
	}
	
	private void isbnIsUnic(String isbn) {
		if(books.containsKey(isbn)) {
			throw new IllegalStateException("Isbn já cadastrado");
		}
	}
}
