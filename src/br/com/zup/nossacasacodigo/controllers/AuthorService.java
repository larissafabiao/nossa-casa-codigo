package br.com.zup.nossacasacodigo.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.database.CollectionOfAuthors;

public class AuthorService {
	CollectionOfAuthors database =  new CollectionOfAuthors();
	
	public Author newAuthor(String name, String email, String description) {
		LocalDateTime dataTime = getDateTime();
		Author newAuthor = new Author(name, email, description, dataTime);
		database.addNewAuthor(newAuthor);
		return newAuthor;
	}

	private LocalDateTime getDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime date = LocalDateTime.now();;
		
		if (formatter.format(date) == null) {
			System.out.println("Data e instante inválidos");
		}
		return date;
	}

	public void showAllAuthors() {
		for (Author print : database.getCollection().values()) { 
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
		for (Author print : database.getCollection().values()) { 
			quantity++;
		}
		return quantity;
	}
}
