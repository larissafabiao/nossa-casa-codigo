package br.com.zup.nossacasacodigo.author;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.zup.nossacasacodigo.auxiliars.IsEmpty;

public class Author {
	private String name;
	private String email;
	private String description;
	private LocalDateTime createdAt;
	
	public Author(String name, String email, String description) {		
		this.name = IsEmpty.check(name, "nome");
		this.email = emailValidator(email);
		this.description = descriptionValidator(description);;
		this.createdAt = LocalDateTime.now();
	}

	//Getters
	public String getEmail() {
		return this.email;
	}
	
	//Validações
	private String emailValidator(String email) {
		IsEmpty.check(email, "email");

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
		return email;
	}

	private String descriptionValidator(String description) {
		IsEmpty.check(description, "descrição");

		if(description.length() > 400) {
			throw new IllegalArgumentException("Tamanho da descrição maior do que o permitido");
		}
		return description;
	}
}
