package br.com.zup.nossacasacodigo.database;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import br.com.zup.nossacasacodigo.book.Book;

public class CollectionsValidatorsAndGetters {
	public static <T> void checkIfIsUnic(String key, Map<String, T> database) {
		if(database.containsKey(key)) {
			throw new IllegalStateException("Já cadastrado");
		}
	}
	
	public void checkIfIsUnicIsbn(String element, Map<String, Book> database) {
		for (Book book : database.values()) {
			if (element.equalsIgnoreCase(book.getIsbn())) {
				throw new IllegalStateException("Já cadastrado");
			}
		}
	}
	
	public static Optional<Book> searchBook(String name, Map<String, Book> database) {
		Optional<Book> bookToReturn = Optional.empty();

		for (Book book : database.values()) {
			if (name.equalsIgnoreCase(((Book) book).getTitle())) {
				bookToReturn = Optional.ofNullable(book);
			}
		}
		return bookToReturn;
	}
}