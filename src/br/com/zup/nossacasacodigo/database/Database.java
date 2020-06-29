package br.com.zup.nossacasacodigo.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.book.Book;
import br.com.zup.nossacasacodigo.category.Category;

public class Database {
	private Map<String, Author> authors =  new HashMap<String, Author>();
	private Map<String, Book> books = new HashMap<String, Book>();
	private Map<String, Category> categories = new HashMap<String, Category>();
	
	public Map<String, Author> addNewAuthor(Author newAuthor) {
		CollectionsValidatorsAndGetters.checkIfIsUnic(newAuthor.getEmail(), authors);
		authors.put(newAuthor.getEmail(), newAuthor);
		return authors;
	}
		
	public Map<String, Book> addBookInDatabase(Book book) {
		CollectionsValidatorsAndGetters.checkIfIsUnic(book.getTitle(), books);
		for (Book bookExistent : books.values()) {
			if (book.getIsbn().equalsIgnoreCase(bookExistent.getIsbn())) {
				throw new IllegalStateException("Já cadastrado");
			}
		}
		books.put(book.getTitle(), book);
		return books;
	}

	public Map<String, Category> addNewCategory(Category category) {
		CollectionsValidatorsAndGetters.checkIfIsUnic(category.getName(), categories);
		categories.put(category.getName(), category); 
		return categories;
	}
	
	public Author searchAuthor(String email) {
		Author wanted = authors.get(email);
		if (wanted != null) {
			return wanted;
		} 
		throw new IllegalStateException("Autor não encontrado");
	}
	
	public Category searchCategory(String name) {
		Category wanted = categories.get(name.toUpperCase());
		if (wanted != null) {
			return wanted;
		} 
		throw new IllegalStateException("Autor não encontrado");
	}
}
