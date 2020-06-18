package br.com.zup.nossacasacodigo.category;

import br.com.zup.nossacasacodigo.auxiliars.IsEmpty;

public class Category {
	private String name;
	
	public Category(String name) {
		IsEmpty verify = new IsEmpty();
		verify.isEmpty(name, "nome");
		this.name = name.toUpperCase();
	}

	public String getName() {
		return name;
	}

}
