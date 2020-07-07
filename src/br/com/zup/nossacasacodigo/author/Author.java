package br.com.zup.nossacasacodigo.author;

import java.time.LocalDateTime;
import br.com.zup.nossacasacodigo.auxiliars.Validators;

public class Author {
	private String name;
	private String email;
	private String description;
	private LocalDateTime createdAt;
	
	public Author(String name, String email, String description) {		
		this.name = Validators.checkNull(name, "nome");
		this.email = Validators.emailValidator(email);
		this.description = descriptionValidator(description);;
		this.createdAt = LocalDateTime.now();
	}

	//Getters
	public String getEmail() {
		return this.email;
	}
	
	//Valida��es
	private String descriptionValidator(String description) {
		Validators.checkNull(description, "descri��o");

		if(description.length() > 400) {
			throw new IllegalArgumentException("Tamanho da descri��o maior do que o permitido");
		}
		return description;
	}

	public String getName() {
		return name;
	}
}
