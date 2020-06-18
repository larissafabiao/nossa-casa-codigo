package br.com.zup.nossacasacodigo.auxiliars;

public class IsEmpty {
	public void isEmpty(String string, String paramether) {
		if (string == null) {
			throw new IllegalArgumentException(paramether + " não pode ser nula");
		}
		if (string.isEmpty()) {
			throw new IllegalArgumentException(paramether + " não pode ser vazia");
		}
		//Verificar se a String não possui algum caractere válido
		if (string.isBlank()) {
			throw new IllegalArgumentException(paramether + " não precisa possuir caracteres válidos");
		}
	}
}
