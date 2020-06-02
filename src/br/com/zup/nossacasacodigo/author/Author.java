package br.com.zup.nossacasacodigo.author;

public class Author {
	// nome, email e uma descrição
	private String name;
	private String email;
	private String description;
	private String createdAt;
	
	public Author() {
		super();
	}
	
	public Author(String name, String email, String description, String createdAt) {
		this.name = name;
		this.email = email;
		this.description = description;
		this.createdAt = createdAt;
	}
	
	//Setters
	public void setEmail(String email) { 
		this.email = email; 
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCreatedAt(String createdAt) {
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
	
	public String getCreatedAt() {
		return this.createdAt;
	}
}
