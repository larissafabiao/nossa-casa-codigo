package br.com.zup.nossacasacodigo.author;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Author {
	private String name;
	private String email;
	private String description;
	private LocalDateTime createdAt;

	public Author(String name, String email, String description) {		
		emailValidator(email);
		nameValidator(name);
		descriptionValidator(description);

		this.name = name;
		this.email = email;
		this.description = description;
		this.createdAt = LocalDateTime.now();
	}

	//Getters
	public String getEmail() {
		return this.email;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}

	//Validações
	private void emailValidator(String email) {
		isEmpty(email, "email");

		boolean isEmailValid = false; 
		if (email != null && email.length() > 0) {
			//Determinamos uma expressão padrão que determina um e-mail válido através da String expression
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			//Definimos nossa expressão como um padrão e a tornamos sensível a letras maiusculas
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			//verificamos se o e-mail inserido obedece ao padrão determinado
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isEmailValid = true;
			}
		}

		if(isEmailValid == false) {
			throw new IllegalArgumentException("Email com formato inválido");
		}
	}

	private void nameValidator(String name) {
		isEmpty(name, "nome");
	}

	private void descriptionValidator(String description) {
		isEmpty(description, "descrição");

		if(description.length() > 400) {
			throw new IllegalArgumentException("Tamanho da descrição maior do que o permitido");
		}
	}

	private void isEmpty(String string, String paramether) {
		if (string == null) {
			throw new IllegalArgumentException(paramether + " não pode ser nula");
		}
		if (string.isEmpty()) {
			throw new IllegalArgumentException(paramether + " não pode ser vazia");
		}
		//Verificar se a String não possui algum caractere válido
		if (string.trim().isEmpty()) {
			throw new IllegalArgumentException(paramether + " não precisa possuir caracteres válidos");
		}
	}
}
