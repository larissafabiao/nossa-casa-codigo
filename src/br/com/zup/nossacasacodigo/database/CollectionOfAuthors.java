package br.com.zup.nossacasacodigo.database;

import java.util.HashMap;
import java.util.Map;

import br.com.zup.nossacasacodigo.author.Author;

public class CollectionOfAuthors {
	Map<String, Author> authors =  new HashMap<String, Author>();
	
	public Map<String, Author> getCollection() {
		return authors;
	}
	
	public void addNewAuthor(Author newAuthor) {
		emailIsUnic(newAuthor.getEmail(), authors);
		authors.put(newAuthor.getEmail(), newAuthor);
	}
	
	private void emailIsUnic(String email, Map<String, Author> authors) {
		if(authors.containsKey(email)){
			throw new IllegalStateException("Email não já cadastrado");
		}
	}
}
