package br.com.zup.nossacasacodigo.database;

import java.util.Map;
import java.util.Optional;

import br.com.zup.nossacasacodigo.book.Book;

public class DatabaseAuxiliars {
	public static <T> void checkIfIsUnic(String key, Map<String, T> database) {
		if(database.containsKey(key.toUpperCase())) {
			throw new IllegalStateException("Já cadastrado");
		}
	}
	
	public static void checkIfIsUnicIsbn(String element, Map<String, Book> database) {
		for (Book book : database.values()) {
			if (element.equalsIgnoreCase(book.getIsbn())) {
				throw new IllegalStateException("Já cadastrado");
			}
		}
	}
	
	public static <T> T searchAuthorOrCategory(String key, Map<String, T> database) {
		Optional<T> returned = searchInDatabase(key, database);
		if (!returned.isPresent()) {
			throw new IllegalStateException("Não encontrado");
		} 
		return returned.get();
	}
	
	public static <T> Optional<T> searchInDatabase (String value, Map<String, T> database) {
		T returned = database.get(value.toUpperCase());
		return Optional.ofNullable(returned);
	}
}