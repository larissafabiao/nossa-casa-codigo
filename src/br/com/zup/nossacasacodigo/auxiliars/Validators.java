package br.com.zup.nossacasacodigo.auxiliars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
	public static String checkNull(String string, String paramether) {
		if(string == null) {
			throw new IllegalArgumentException(paramether + " n�o pode ser nula");
		}
		if (string.isBlank()) {
			throw new IllegalArgumentException(paramether + " precisa possuir caracteres v�lidos");
		}
		return string;
	}
	
	public static String emailValidator(String email) {
		checkNull(email, "email");

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
	
}
