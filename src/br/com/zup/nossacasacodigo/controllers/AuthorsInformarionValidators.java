package br.com.zup.nossacasacodigo.controllers;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;

import br.com.zup.nossacasacodigo.author.Author;

public class AuthorsInformarionValidators {
	public static void emailValidator(String email) {
		isEmpty(email);

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
			throw new IllegalArgumentException();
		}
	}
	
	public static void emailIsUnic(String email, Map<String, Author> authors) {
		if(authors.containsKey(email)){
			throw new RuntimeException("Email j� cadastrado");
		}
	}

	public static void dateValidator(Date dataTime) {
		isEmpty(dataTime.toString());
	}

	public static void nameValidator(String name) {
		isEmpty(name);
	}

	public static void descriptionValidator(String description) {
		isEmpty(description);

		if(description.length() > 400) {
			throw new IllegalArgumentException();
		}
	}

	public static void isEmpty(String string) {
		if (string == null) {
			throw new RuntimeException("Erro de Preenchimento de String");
		}
		//Verificar se a String est� vazia
		if (string.isEmpty()) {
			throw new RuntimeException("Erro de Preenchimento de String");
		}
		//Verificar se a String n�o possui algum caractere v�lido
		if (string.trim().isEmpty()) {
			throw new RuntimeException("Erro de Preenchimento de String");
		}
	}


}
