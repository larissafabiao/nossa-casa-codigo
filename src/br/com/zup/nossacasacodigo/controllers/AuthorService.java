package br.com.zup.nossacasacodigo.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import br.com.zup.nossacasacodigo.author.Author;

public class AuthorService {
	Validator check = new Validator();
	List<Author> listAuthor = new LinkedList<>();

	//Métodos de inserção de um novo Autor
	public void newAuthor(String name, String email, String description) {
		String dataTime = getDateTime();

		//validações
		check.emailValidator(email);
		check.nameValidator(name);
		check.descriptionValidator(description);
		check.dateValidator(dataTime);

		//Inserção caso não estore nenhuma exception nas validações
		Author newAuthor = new Author(name, email, description, dataTime);
		listAuthor.add(newAuthor);
	}

	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();

		if (dateFormat.format(date) == null) {
			System.out.println("Data e instante inválidos");
		}

		return dateFormat.format(date);
	}

	//Busca e impressão dos autores na lista
	public void showAllAuthors() {
		for (Author it : listAuthor) {
			showOne(it);
		}
	}

	void showOne(Author author) {
		System.out.println("-------------------------------------------------");
		System.out.println("Autor: " + author.getName());
		System.out.println("Email: " + author.getEmail());
		System.out.println("Descrição: " + author.getDescription());
		System.out.println("Criado em: " + author.getCreatedAt());
		System.out.println("-------------------------------------------------");
	}
}
