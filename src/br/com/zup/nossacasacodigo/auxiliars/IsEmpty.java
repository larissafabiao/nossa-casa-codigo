package br.com.zup.nossacasacodigo.auxiliars;

public class IsEmpty {
	public void isEmpty(String string, String paramether) {
		if (string == null) {
			throw new IllegalArgumentException(paramether + " n�o pode ser nula");
		}
		if (string.isEmpty()) {
			throw new IllegalArgumentException(paramether + " n�o pode ser vazia");
		}
		//Verificar se a String n�o possui algum caractere v�lido
		if (string.isBlank()) {
			throw new IllegalArgumentException(paramether + " n�o precisa possuir caracteres v�lidos");
		}
	}
}
