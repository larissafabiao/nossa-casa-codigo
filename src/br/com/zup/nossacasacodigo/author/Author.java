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
	
	//Valida��es
	private String emailValidator(String email) {
		IsEmpty.check(email, "email");

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
		return email;
	}

	private String descriptionValidator(String description) {
		IsEmpty.check(description, "descri��o");

		if(description.length() > 400) {
			throw new IllegalArgumentException("Tamanho da descri��o maior do que o permitido");
		}
		return description;
	}
}
