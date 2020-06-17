package br.com.zup.nossacasacodigo.author;

import java.util.HashMap;
import java.util.Map;

public class RepositoryOfAuthors {
	private Map<String, Author> authors =  new HashMap<String, Author>();
	
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
}
