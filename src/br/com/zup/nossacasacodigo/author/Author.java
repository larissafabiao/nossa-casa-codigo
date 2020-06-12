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

	//Valida��es
	private void emailValidator(String email) {
		isEmpty(email, "email");

		boolean isEmailValid = false; 
		if (email != null && email.length() > 0) {
			//Determinamos uma express�o padr�o que determina um e-mail v�lido atrav�s da String expression
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			//Definimos nossa express�o como um padr�o e a tornamos sens�vel a letras maiusculas
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			//verificamos se o e-mail inserido obedece ao padr�o determinado
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isEmailValid = true;
			}
		}

		if(isEmailValid == false) {
			throw new IllegalArgumentException("Email com formato inv�lido");
		}
	}

	private void nameValidator(String name) {
		isEmpty(name, "nome");
	}

	private void descriptionValidator(String description) {
		isEmpty(description, "descri��o");

		if(description.length() > 400) {
			throw new IllegalArgumentException("Tamanho da descri��o maior do que o permitido");
		}
	}

	private void isEmpty(String string, String paramether) {
		if (string == null) {
			throw new IllegalArgumentException(paramether + " n�o pode ser nula");
		}
		if (string.isEmpty()) {
			throw new IllegalArgumentException(paramether + " n�o pode ser vazia");
		}
		//Verificar se a String n�o possui algum caractere v�lido
		if (string.trim().isEmpty()) {
			throw new IllegalArgumentException(paramether + " n�o precisa possuir caracteres v�lidos");
		}
	}
}
