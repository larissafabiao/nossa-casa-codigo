package br.com.zup.nossacasacodigo.auxiliars;

import java.util.Objects;

public class IsEmpty {
	public static void check(String string, String paramether) {
		Objects.requireNonNull(string, paramether + " não pode ser nula");
		if (string.isBlank()) {
			throw new IllegalArgumentException(paramether + " não precisa possuir caracteres válidos");
		}
	}
}
