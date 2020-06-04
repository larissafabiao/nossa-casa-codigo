package br.com.zup.nossacasacodigo.author;

import java.util.Date;

import br.com.zup.nossacasacodigo.controllers.AuthorService;

public class Author {
	private String name;
	private String email;
	private String description;
	private Date createdAt;
	
	public Author(String name, String email, String description, Date createdAt) {
		AuthorService service = new AuthorService();
		
		service.validateAllData(name, email, description, createdAt);
		
		this.name = name;
		this.email = email;
		this.description = description;
		this.createdAt = createdAt;
	}
	
	//Getters
	public String getEmail() {
		return this.email;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Date getCreatedAt() {
		return this.createdAt;
	}
}
