package br.com.zup.nossacasacodigo.database;

import java.util.HashMap;
import java.util.Map;

import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.category.Category;

public class Database {
	private static Map<String, Author> authors =  new HashMap<String, Author>();
	private static Map<String, Category> categories = new HashMap<String, Category>();
	
	public Map<String, Author> addNewAuthor(Author newAuthor) {
		emailIsUnic(newAuthor.getEmail());
		authors.put(newAuthor.getEmail(), newAuthor);
		return authors;
	}
	
	public Map<String, Category> addNewCategory(Category category) {
		categoryIsUnic(category.getName());
		categories.put(category.getName(), category); 
		return categories;
	}
	
	private void emailIsUnic(String email) {
		if(this.authors.containsKey(email)){
			throw new IllegalStateException("Email não já cadastrado");
		}
	}
	
	private void categoryIsUnic(String categoryName) {
		if(this.authors.containsKey(categoryName)){
			throw new IllegalStateException("Categoria não já cadastrada");
		}
	}
	
	public static void main(String Args) {
		Database primeira = new Database();
		Category newCategory = new Category("Terror");
		Map<String, Category> categorias = primeira.addNewCategory(newCategory);
		System.out.println(categorias);
	}
}