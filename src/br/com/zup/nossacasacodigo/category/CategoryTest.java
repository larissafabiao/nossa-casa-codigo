package br.com.zup.nossacasacodigo.category;

import org.junit.Assert;
import org.junit.Test;

public class CategoryTest {
	@Test
	public void TestingTheCreationOfAInstanceOfCategoryWithValidInformations () {
		Category category = new Category("Terror");
		Assert.assertEquals("Terror".toUpperCase(), category.getName());
	}
	
	@Test
	public void TestingTheCreationOfAInstanceOfCategoryWithANullNameReturningNullPointerException () {
		Assert.assertThrows(NullPointerException.class, () -> new Category(null));
	}
	
	@Test
	public void TestingTheCreationOfAInstanceOfCategoryWithAEmptyNameReturningIllegalArgumentException () {
		Assert.assertThrows(IllegalArgumentException.class, () -> new Category(""));
	}
}
