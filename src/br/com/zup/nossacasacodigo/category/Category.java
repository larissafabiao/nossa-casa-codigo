package br.com.zup.nossacasacodigo.category;

import br.com.zup.nossacasacodigo.auxiliars.IsEmpty;

public class Category {
	private String name;
	
	public Category(String name) {
		this.name = IsEmpty.check(name, "nome").toUpperCase();
	}

	public String getKey() {
		return name;
	}

}
