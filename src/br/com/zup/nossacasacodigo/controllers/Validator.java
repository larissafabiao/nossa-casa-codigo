package br.com.zup.nossacasacodigo.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	public void emailValidator(String email) {
		//verificar se � uma string nula ou vazia
		isEmpty(email);

		//verifica se � um e-mail v�lido
		boolean isEmailValid = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isEmailValid = true;
			}
		}

		if(isEmailValid == false) {
			throw new RuntimeException("Email inv�lido");
		}
	}

	public void dateValidator(String dataTime) {
		isEmpty(dataTime);
	}

	public void nameValidator(String name) {
		isEmpty(name);
	}

	public void descriptionValidator(String description) {
		isEmpty(description);

		if(description.length() > 400) {
			throw new RuntimeException("Descri��o maior do que o m�ximo permitido");
		}
	}

	public void isEmpty(String string) {
		if (string == null) {
			throw new RuntimeException("Erro de Preenchimento de String");
		}
		//2- Verificar se a String est� vazia
		if (string.isEmpty()) {
			throw new RuntimeException("Erro de Preenchimento de String");
		}
		//3 - Verificar se a String n�o possui algum caractere v�lido
		if (string.trim().isEmpty()) {
			throw new RuntimeException("Erro de Preenchimento de String");
		}
	}


}
