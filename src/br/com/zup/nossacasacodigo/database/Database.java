package br.com.zup.nossacasacodigo.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.book.Book;
import br.com.zup.nossacasacodigo.category.Category;

public class Database {
	private Map<String, Author> authors =  new HashMap<String, Author>();
	private Map<String, Book> books = new HashMap<String, Book>();
	private Map<String, Category> categories = new HashMap<String, Category>();
	
	public Map<String, Author> addNewAuthor(Author newAuthor) {
		checkIfIsUnic(newAuthor.getEmail(), authors);
		authors.put(newAuthor.getEmail(), newAuthor);
		return authors;
	}
		
	public Map<String, Book> addBookInDatabase(Book book) {
		checkIfIsUnic(book.getIsbn(), books);
		books.put(book.getIsbn(), book);
		
		return books;
	}

	public Map<String, Category> addNewCategory(Category category) {
		checkIfIsUnic(category.getName(), categories);
		categories.put(category.getName(), category); 
		return categories;
	}
	
	private <T> void checkIfIsUnic(String key, Map<String, T> database) {
		if(database.containsKey(key)) {
			throw new IllegalStateException("J� cadastrado");
		}
	}
	
	public Author searchAuthor(String email) {
		Author wanted = authors.get(email);
		if (wanted != null) {
			return wanted;
		} 
		throw new IllegalStateException("Autor n�o encontrado");
	}
	
	public Category searchCategory(String name) {
		Category wanted = categories.get(name.toUpperCase());
		if (wanted != null) {
			return wanted;
		} 
		throw new IllegalStateException("Autor n�o encontrado");
	}
	
	public Optional<Book> searchBook(String name) {
		Optional<Book> bookToReturn = Optional.empty();

		for (Book book : books.values()) {
			if (name.equalsIgnoreCase(book.getTitle())) {
				bookToReturn = Optional.ofNullable(book);
			}
		}
		return bookToReturn;
	}
}
