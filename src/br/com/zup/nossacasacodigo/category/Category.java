package br.com.zup.nossacasacodigo.category;

public class Category {
	private String name;
	
	public Category(String name) {
		isEmpty(name, "nome");
		this.name = name.toUpperCase();
	}

	public String getName() {
		return name;
	}
	
	private void isEmpty(String string, String paramether) {
		if (string == null) {
			throw new IllegalArgumentException(paramether + " n�o pode ser nula");
		}
		if (string.isEmpty()) {
			throw new IllegalArgumentException(paramether + " n�o pode ser vazia");
		}
		//Verificar se a String n�o possui algum caractere v�lido
		if (string.trim().isEmpty()) {
			throw new IllegalArgumentException(paramether + " n�o precisa possuir caracteres v�lidos");
		}
	}
}
