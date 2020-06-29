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
		DatabaseValidators.checkIfIsUnic(newAuthor.getEmail(), authors);
		authors.put(newAuthor.getEmail().toUpperCase(), newAuthor);
		return authors;
	}
		
	public Map<String, Book> addBookInDatabase(Book book) {
		DatabaseValidators.checkIfIsUnic(book.getTitle(), books);
		DatabaseValidators.checkIfIsUnicIsbn(book.getIsbn(), books);
		books.put(book.getTitle(), book);
		return books;
	}

	public Map<String, Category> addNewCategory(Category category) {
		DatabaseValidators.checkIfIsUnic(category.getName(), categories);
		categories.put(category.getName().toUpperCase(), category); 
		return categories;
	}
	
	public <T> T searchAuthorOrCategory(String key, Map<String, T> database) {
		Optional<T> returned = searchInDatabase(key, database);
		if (!returned.isPresent()) {
			throw new IllegalStateException("Não encontrado");
		} 
		return returned.get();
	}
	
	public <T> Optional<T> searchInDatabase (String value, Map<String, T> database) {
		T returned = database.get(value.toUpperCase());
		return Optional.ofNullable(returned);
	}
}
