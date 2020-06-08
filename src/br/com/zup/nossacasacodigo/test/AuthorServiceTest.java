package br.com.zup.nossacasacodigo.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.database.CollectionOfAuthors;
import junit.framework.TestCase;

public class AuthorServiceTest extends TestCase {
	@Test
	public void testIncludingNewAuthor() {
		String name = "Larissa Fabião da Fonseca";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		CollectionOfAuthors database = new CollectionOfAuthors();
		
		Author newAuthor = new Author(name, email, description);
		database.addNewAuthor(newAuthor);
				
		Assert.assertNotNull(newAuthor);
		Assert.assertEquals( newAuthor.getName(), name);
		Assert.assertEquals(newAuthor.getEmail(), email);
		Assert.assertEquals(newAuthor.getDescription(), description);
		Assert.assertEquals(1, quantityOfAuthors(database));
	}
	
	@Test
	public void testIncludingMoreThanOneAuthor() {
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
		Assert.assertNotNull(newAuthorOne);
		Assert.assertEquals( newAuthorOne.getName(), name);
		Assert.assertEquals(newAuthorOne.getEmail(), email);
		Assert.assertEquals(newAuthorOne.getDescription(), description);
		
		Assert.assertNotNull(newAuthorTwo);
		Assert.assertEquals( newAuthorTwo.getName(), nameTwo);
		Assert.assertEquals(newAuthorTwo.getEmail(), emailTwo);
		Assert.assertEquals(newAuthorTwo.getDescription(), descriptionTwo);
		
		
		Assert.assertEquals(2, quantityOfAuthors(database));
	}
	
	private int quantityOfAuthors(CollectionOfAuthors database) {
		int quantity = 0;
		for (Author print : database.getCollection().values()) { 
			quantity++;
		}
		return quantity;
	}
	
}
