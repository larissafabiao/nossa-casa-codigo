package br.com.zup.nossacasacodigo.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.controllers.AuthorService;
import junit.framework.TestCase;

public class AuthorServiceTest extends TestCase {
	@Test
	public void test() {
		String name = "Larissa Fabião da Fonseca";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		AuthorService service = new AuthorService();
		
		Author newAuthor = service.newAuthor(name, email, description);
		
		Assert.assertNotNull(newAuthor);
		Assert.assertEquals( newAuthor.getName(), name);
		Assert.assertEquals(newAuthor.getEmail(), email);
		Assert.assertEquals(newAuthor.getDescription(), description);
	}
}
