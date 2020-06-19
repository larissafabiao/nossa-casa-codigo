package br.com.zup.nossacasacodigo.database;

import java.util.HashMap;
import java.util.Map;

import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.book.Book;
import br.com.zup.nossacasacodigo.category.Category;

public class Database {
	private Map<String, Author> authors =  new HashMap<String, Author>();
	private Map<String, Book> books = new HashMap<String, Book>();
	private Map<String, Category> categories = new HashMap<String, Category>();
	
	public Map<String, Author> addNewAuthor(Author newAuthor) {
		checkIfIsUnic(newAuthor.getKey(), authors);
		authors.put(newAuthor.getKey(), newAuthor);
		return authors;
	}
		
	public Map<String, Book> addBookInDatabase(Book book) {
		checkIfIsUnic(book.getIsbn(), books);
		books.put(book.getIsbn(), book);
		
		return books;
	}

	public Map<String, Category> addNewCategory(Category category) {
		checkIfIsUnic(category.getKey(), categories);
		categories.put(category.getKey(), category); 
		return categories;
	}
	
	private <T> void checkIfIsUnic(String key, Map<String, T> database) {
		if(database.containsKey(key)) {
			throw new IllegalStateException("Já cadastrado");
		}
	}
}
