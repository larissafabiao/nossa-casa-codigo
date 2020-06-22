package br.com.zup.nossacasacodigo.auxiliars;

import java.util.Objects;

public class IsEmpty {
	public static String check(String string, String paramether) {
		if(string == null) {
			throw new IllegalArgumentException(paramether + " n�o pode ser nula");
		}
		if (string.isBlank()) {
			throw new IllegalArgumentException(paramether + " precisa possuir caracteres v�lidos");
		}
		return string;
	}
}
