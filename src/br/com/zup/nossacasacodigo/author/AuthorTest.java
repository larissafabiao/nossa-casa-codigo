package br.com.zup.nossacasacodigo.author;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import junit.framework.TestCase;

public class AuthorTest extends TestCase{
	@Test
	public void testIncludingNewAuthorReturningAValidAuthor() {
		String name = "X Æ A-12";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		Author newAuthor = new Author(name, email, description);
				
		Assert.assertEquals( newAuthor.getName(), name);
		Assert.assertEquals(newAuthor.getEmail(), email);
		Assert.assertEquals(newAuthor.getDescription(), description);
	}
	
	@Test
	public void testIncludeANewAuthorWithAEmptyNameReturingAnException() {
		String name = "";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Author(name, email, description));
	}
	
	@Test
	public void includeANewAuthorWithANullNameReturingAnException() {
		String name = null;
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		Assert.assertThrows(IllegalArgumentException.class, () -> new Author(name, email, description));
	}
	
	@Test
	public void includeANewAuthorWithAEmptyEmailReturingAnException() {
		String name = "Larissa Fabião da Fonseca";
		String email = "";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		Assert.assertThrows(IllegalArgumentException.class, () -> new Author(name, email, description));
	}
	
	@Test
	public void includeANewAuthorWithANullEmailReturingAnException() {
		String name = "Larissa Fabião da Fonseca";
		String email = null;
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		Assert.assertThrows(IllegalArgumentException.class, () -> new Author(name, email, description));
	}
	
	@Test
	public void includeANewAuthorWithAEmptyDescriptionReturingAnException() {
		String name = "Larissa Fabião da Fonseca";
		String email = "larissafabiao@gmail.com";
		String description = "";	
		Assert.assertThrows(IllegalArgumentException.class, () -> new Author(name, email, description));
	}
	
	@Test
	public void includeANewAuthorWithANullDescriptionReturingAnException() {
		String name = "Larissa Fabião da Fonseca";
		String email = null;
		String description = null;
		Assert.assertThrows(IllegalArgumentException.class, () -> new Author(name, email, description));
	}
}

