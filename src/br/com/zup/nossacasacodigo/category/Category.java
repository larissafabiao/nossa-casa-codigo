package br.com.zup.nossacasacodigo.category;

import br.com.zup.nossacasacodigo.auxiliars.Validators;

public class Category {
	private String name;
	
	public Category(String name) {
		this.name = Validators.checkNull(name, "nome").toUpperCase();
	}

	public String getName() {
		return name;
	}

}
