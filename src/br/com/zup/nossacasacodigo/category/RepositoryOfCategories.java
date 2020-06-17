package br.com.zup.nossacasacodigo.category;

import java.util.HashMap;
import java.util.Map;

public class RepositoryOfCategories {
	private Map<String, Category> categories = new HashMap<String, Category>();
	
	public Map<String, Category> addNewCategory(Category category) {
		categoryIsUnic(category.getName());
		categories.put(category.getName(), category); 
		return categories;
	}
	
	private void categoryIsUnic(String categoryName) {
		if(categories.containsKey(categoryName)){
			throw new IllegalStateException("Categoria já cadastrada");
		}
	}
}
