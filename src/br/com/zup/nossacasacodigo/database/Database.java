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
		emailIsUnic(newAuthor.getEmail());
		authors.put(newAuthor.getEmail(), newAuthor);
		return authors;
	}
	
	private void emailIsUnic(String email) {
		if(authors.containsKey(email)){
			throw new IllegalStateException("Email já cadastrado");
		}
	}
		
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

	public Map<String, Category> addNewCategory(Category category) {
		categoryIsUnic(category.getName());
		categories.put(category.getName(), category); 
		return categories;
	}
	
	private void categoryIsUnic(String categoryName) {
		if(categories.containsKey(categoryName)){
			throw new IllegalStateException("Categoria já cadastrada");
		}
	}
}
