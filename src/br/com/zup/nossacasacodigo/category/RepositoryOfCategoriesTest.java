package br.com.zup.nossacasacodigo.category;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class RepositoryOfCategoriesTest {
	@Test
	public void testeWithOneCategory() {
		RepositoryOfCategories database = new RepositoryOfCategories();
		Category categoryCreted = new Category("terror");
		
		Map<String, Category> categories = database.addNewCategory(categoryCreted);
		Assert.assertEquals(categories.size(), 1);
	}
}
