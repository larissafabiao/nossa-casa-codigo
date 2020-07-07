package br.com.zup.nossacasacodigo.auxiliars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
	public static String checkNull(String string, String paramether) {
		if(string == null) {
			throw new IllegalArgumentException(paramether + " não pode ser nula");
		}
		if (string.isBlank()) {
			throw new IllegalArgumentException(paramether + " precisa possuir caracteres válidos");
		}
		return string;
	}
	
	public static String emailValidator(String email) {
		checkNull(email, "email");

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
	
}
