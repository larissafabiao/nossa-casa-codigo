package br.com.zup.nossacasacodigo.database;

import java.util.Map;
import br.com.zup.nossacasacodigo.book.Book;

public class CollectionsValidatorsAndGetters {
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
}