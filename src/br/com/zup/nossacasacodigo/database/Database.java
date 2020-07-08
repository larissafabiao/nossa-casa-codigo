package br.com.zup.nossacasacodigo.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.book.Book;
import br.com.zup.nossacasacodigo.cart.DiscountCoupon;
import br.com.zup.nossacasacodigo.category.Category;
import br.com.zup.nossacasacodigo.client.Client;

public class Database {
	private Map<String, Author> authors =  new HashMap<>();
	private Map<String, Book> books = new HashMap<>();
	private Map<String, Category> categories = new HashMap<>();
	private Map<String, Client> clients =  new HashMap<>();
	private Map<String, DiscountCoupon> coupons =  new HashMap<>();
	
	public Map<String, Author> addNewAuthor(Author newAuthor) {
		DatabaseAuxiliars.checkIfIsUnic(newAuthor.getEmail(), authors);
		authors.put(newAuthor.getEmail().toUpperCase(), newAuthor);
		return authors;
	}
		
	public Map<String, Book> addBookInDatabase(Book book) {
		DatabaseAuxiliars.checkIfIsUnic(book.getTitle(), books);
		DatabaseAuxiliars.checkIfIsUnicIsbn(book.getIsbn(), books);
		books.put(book.getTitle(), book);
		return books;
	}

	public Map<String, Category> addNewCategory(Category category) {
		DatabaseAuxiliars.checkIfIsUnic(category.getName(), categories);
		categories.put(category.getName().toUpperCase(), category); 
		return categories;
	}
	
	public Author searchAuthor(String email) {
		Author wanted = DatabaseAuxiliars.searchAuthorOrCategory(email, authors);
		return wanted;
	}
	
	public Category searchCategory(String name) {
		Category wanted = DatabaseAuxiliars.searchAuthorOrCategory(name, categories);
		return wanted;
	}
	
	public Optional<Book> seachBook(String name) {
		Optional<Book> wanted = DatabaseAuxiliars.searchInDatabase(name, books);
		return wanted;
	}
}
