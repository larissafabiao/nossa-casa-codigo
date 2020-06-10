package br.com.zup.nossacasacodigo.database;

import org.junit.Assert;
import org.junit.Test;

import br.com.zup.nossacasacodigo.author.Author;

public class AuthorsTest {
	@Test
	public void testWithOneAutor() {
		String name = "Larissa Fabião da Fonseca";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";

		CollectionOfAuthors database = new CollectionOfAuthors();
		
		Author newAuthorOne = new Author(name, email, description);
		
		database.addNewAuthor(newAuthorOne);
		
		Assert.assertTrue(database.getCollection().containsValue(newAuthorOne));	
		Assert.assertEquals(database.getCollection().size(), 1);
	}
	
	@Test
	public void testWithTwoAuthors() {
		String name = "Larissa Fabião da Fonseca";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		String nameTwo = "Larissa Fonseca";
		String emailTwo = "larissao@gmail.com";
		//texto de exemplo com menos de 400 caracteres
		String descriptionTwo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci.  Nulla at porttitor turpis.";
		
		CollectionOfAuthors database = new CollectionOfAuthors();
		
		Author newAuthorOne = new Author(name, email, description);
		Author newAuthorTwo = new Author(nameTwo, emailTwo, descriptionTwo);
		
		database.addNewAuthor(newAuthorOne);
		database.addNewAuthor(newAuthorTwo);
		
		Assert.assertTrue(database.getCollection().containsValue(newAuthorOne));	
		Assert.assertTrue(database.getCollection().containsValue(newAuthorTwo));
		Assert.assertEquals(database.getCollection().get(email), newAuthorOne);
		Assert.assertEquals(database.getCollection().get(emailTwo), newAuthorTwo);
		Assert.assertEquals(database.getCollection().size(), 2);
	}
	
}

