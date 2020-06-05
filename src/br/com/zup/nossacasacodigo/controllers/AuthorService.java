package br.com.zup.nossacasacodigo.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import br.com.zup.nossacasacodigo.author.Author;

public class AuthorService {
	Map<String, Author> authors =  new HashMap<String, Author>();
	
	public Author newAuthor(String name, String email, String description) {
		Date dataTime = getDateTime();
		Author newAuthor = new Author(name, email, description, dataTime);
		AuthorsInformarionValidators.emailIsUnic(newAuthor.getEmail(), authors);
		authors.put(email, newAuthor);
		return newAuthor;
	}

	private Date getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
				
		if (dateFormat.format(date) == null) {
			System.out.println("Data e instante inválidos");
		}

		return date;
	}

	public void showAllAuthors() {
		for (Author print : authors.values()) { 
			showOne(print);
		}
	}
	
	public void showOne(Author author) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String date = dateFormat.format(author.getCreatedAt());
		
		System.out.println("-------------------------------------------------");
		System.out.println("Autor: " + author.getName());
		System.out.println("Email: " + author.getEmail());
		System.out.println("Descrição: " + author.getDescription());
		System.out.println("Criado em: " + date);
		System.out.println("-------------------------------------------------");
	}
	
	public int quantityOfAuthors() {
		int quantity = 0;
		for (Author print : authors.values()) { 
			quantity++;
		}
		return quantity;
	}
}
