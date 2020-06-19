package br.com.zup.nossacasacodigo.auxiliars;

import java.util.Objects;

public class IsEmpty {
	public static String check(String string, String paramether) {
		Objects.requireNonNull(string, paramether + " n�o pode ser nula");
		if (string.isBlank()) {
			throw new IllegalArgumentException(paramether + " n�o precisa possuir caracteres v�lidos");
		}
		return string;
	}
}
