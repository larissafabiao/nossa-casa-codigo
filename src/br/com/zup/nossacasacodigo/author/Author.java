package br.com.zup.nossacasacodigo.author;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
		
		LocalDateTime dataTime = getDateTime();
		dateValidator(dataTime);
		
		this.name = name;
		this.email = email;
		this.description = description;
		this.createdAt = dataTime;
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
	
	private LocalDateTime getDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime date = LocalDateTime.now();
		
		if (formatter.format(date) == null) {
			System.out.println("Data e instante inválidos");
		}
		return date;
	}
	//Validações
	private void emailValidator(String email) {
		isEmpty(email);

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
			throw new IllegalArgumentException();
		}
	}

	private void dateValidator(LocalDateTime dataTime) {
		isEmpty(dataTime.toString());
	}

	private void nameValidator(String name) {
		isEmpty(name);
	}

	private void descriptionValidator(String description) {
		isEmpty(description);

		if(description.length() > 400) {
			throw new IllegalArgumentException();
		}
	}

	private void isEmpty(String string) {
		if (string == null) {
			throw new RuntimeException("Erro de Preenchimento de String");
		}
		//Verificar se a String está vazia
		if (string.isEmpty()) {
			throw new RuntimeException("Erro de Preenchimento de String");
		}
		//Verificar se a String não possui algum caractere válido
		if (string.trim().isEmpty()) {
			throw new RuntimeException("Erro de Preenchimento de String");
		}
	}
}
