package br.com.zup.nossacasacodigo.database;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.category.Category;

public class DatabaseTest {
	private Database database;
	
	@BeforeEach
	public void setup() {
		this.database = new Database();
	}
	
	@Test
	public void testWithOneAutor() {
		String name = "Larissa Fabião da Fonseca";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";

		//Database database = new Database();
		
		Author newAuthorOne = new Author(name, email, description);
		
		Map<String, Author> authors = database.addNewAuthor(newAuthorOne);
		
		Assert.assertTrue(authors.containsValue(newAuthorOne));	
		Assert.assertEquals(authors.size(), 1);
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
		
		//Database database = new Database();
		
		Author newAuthorOne = new Author(name, email, description);
		Author newAuthorTwo = new Author(nameTwo, emailTwo, descriptionTwo);
		
		Map<String, Author> authors = database.addNewAuthor(newAuthorOne);
		authors =database.addNewAuthor(newAuthorTwo);
		
		Assert.assertTrue(authors.containsValue(newAuthorOne));	
		Assert.assertTrue(authors.containsValue(newAuthorTwo));
		Assert.assertEquals(authors.get(email), newAuthorOne);
		Assert.assertEquals(authors.get(emailTwo), newAuthorTwo);
		Assert.assertEquals(authors.size(), 2);
	}
	
	@Test
	public void testWithAnEmailPreviouslyCadastredReturningAnException() {
		String name = "Larissa Fabião da Fonseca";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		String nameTwo = "Larissa Fonseca";
		String emailTwo = "larissafabiao@gmail.com";
		//texto de exemplo com menos de 400 caracteres
		String descriptionTwo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci.  Nulla at porttitor turpis.";
		
		//Database database = new Database();
		
		Author newAuthorOne = new Author(name, email, description);
		Author newAuthorTwo = new Author(nameTwo, emailTwo, descriptionTwo);
		
		database.addNewAuthor(newAuthorOne);
		Assertions.assertThrows(IllegalStateException.class, () -> database.addNewAuthor(newAuthorTwo));
	}
	
	@Test
	public void testeWithOneCategory() {
		//Database database = new Database();
		Category categoryCreted = new Category("terror");
		
		Map<String, Category> categories = database.addNewCategory(categoryCreted);
		Assert.assertEquals(categories.size(), 1);
	}
}

