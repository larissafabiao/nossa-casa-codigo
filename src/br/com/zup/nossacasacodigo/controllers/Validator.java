package br.com.zup.nossacasacodigo.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	public void emailValidator(String email) {
		//verificar se é uma string nula ou vazia
		isEmpty(email);

		//verifica se é um e-mail válido
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
			throw new RuntimeException("Email inválido");
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
			throw new RuntimeException("Descrição maior do que o máximo permitido");
		}
	}

	public void isEmpty(String string) {
		if (string == null) {
			throw new RuntimeException("Erro de Preenchimento de String");
		}
		//2- Verificar se a String está vazia
		if (string.isEmpty()) {
			throw new RuntimeException("Erro de Preenchimento de String");
		}
		//3 - Verificar se a String não possui algum caractere válido
		if (string.trim().isEmpty()) {
			throw new RuntimeException("Erro de Preenchimento de String");
		}
	}


}
