package br.com.zup.nossacasacodigo.category;

import org.junit.Assert;
import org.junit.Test;

public class CategoryTest {
	@Test
	public void testingTheCreationOfAInstanceOfCategoryWithValidInformations () {
		Category category = new Category("Terror");
	}
	
	@Test
	public void testingTheCreationOfAInstanceOfCategoryWithANullNameReturningNullPointerException () {
		Assert.assertThrows(NullPointerException.class, () -> new Category(null));
	}
	
	@Test
	public void testingTheCreationOfAInstanceOfCategoryWithAEmptyNameReturningIllegalArgumentException () {
		Assert.assertThrows(IllegalArgumentException.class, () -> new Category(""));
	}
}
