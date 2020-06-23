package br.com.zup.nossacasacodigo.book;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.category.Category;

public class BookTest {
	@Test
	public void creationOfABookWithValidInformatiosReturningASucessInclusion() {
		String title = "O pequeno Principe";
		//Synopsis com exatamente 500 caracteres
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		BigDecimal price = new BigDecimal("25.0");
		int pages = 120;
		String isbn = "Livro1";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("clássico moderno");

		String name = "Fernando Boaglio";
		String email = "larissafabiao@gmail.com";
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		Author fernandoBoaglio = new Author(name, email, description);
		
		Book oPequenoPrincipe = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, fernandoBoaglio);
	}

	@Test
	public void creationOfABookWithAnInvalidSynopsisReturingAnIllegalArgumentException() {
		String title = "O pequeno Principe";
		//Synopsis com exatamente 512 caracteres
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue dolor sit amet sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		BigDecimal price = new BigDecimal("25.0");
		int pages = 120;
		String isbn = "Livro1";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("clássico moderno");

		String name = "Fernando Boaglio";
		String email = "larissafabiao@gmail.com";
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		Author fernandoBoaglio = new Author(name, email, description);
		
		Assert.assertThrows(IllegalArgumentException.class, () -> new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, fernandoBoaglio));
	}

	@Test
	public void creationOfABookWithAnInvalidPriceReturingAnIllegalArgumentException() {
		String title = "O pequeno Principe";
		//Synopsis com exatamente 500 caracteres
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		BigDecimal price = new BigDecimal("19.99");
		int pages = 120;
		String isbn = "Livro1";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("clássico moderno");

		String name = "Fernando Boaglio";
		String email = "larissafabiao@gmail.com";
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		Author fernandoBoaglio = new Author(name, email, description);
		
		Assert.assertThrows(IllegalArgumentException.class, () -> new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, fernandoBoaglio));
	}

	@Test
	public void creationOfABookWithAnInvalidPagesReturingAnIllegalArgumentException() {
		String title = "O pequeno Principe";
		//Synopsis com exatamente 512 caracteres
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue dolor sit amet sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		BigDecimal price = new BigDecimal("25.0");
		int pages = 90;
		String isbn = "Livro1";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("clássico moderno");

		String name = "Fernando Boaglio";
		String email = "larissafabiao@gmail.com";
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		Author fernandoBoaglio = new Author(name, email, description);
		
		Assert.assertThrows(IllegalArgumentException.class, () -> new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, fernandoBoaglio));
	}

	@Test
	public void creationOfABookWithAnInvalidPublicationDateReturingAnIllegalArgumentException() {
		String title = "O pequeno Principe";
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		BigDecimal price = new BigDecimal("25.0");
		int pages = 100;
		String isbn = "Livro1";
		LocalDate publicationDate = LocalDate.of(2020,5,16);
		Category category = new Category("clássico moderno");

		String name = "Fernando Boaglio";
		String email = "larissafabiao@gmail.com";
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		Author fernandoBoaglio = new Author(name, email, description);
		
		Assert.assertThrows(IllegalArgumentException.class, () -> new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, fernandoBoaglio));
	}

	@Test
	public void creationOfABookWithANullCategoryReturingAnIllegalArgumentException() {
		String title = "O pequeno Principe";
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		BigDecimal price = new BigDecimal("25.0");
		int pages = 100;
		String isbn = "Livro1";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = null;

		String name = "Fernando Boaglio";
		String email = "larissafabiao@gmail.com";
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		Author fernandoBoaglio = new Author(name, email, description);
		
		Assert.assertThrows(IllegalArgumentException.class, () -> new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, fernandoBoaglio));
	}
	
	@Test
	public void creationOfABookWithANullAuthorReturiningAnIllegalArgumentException() {
		String title = "O pequeno Principe";
		//Synopsis com exatamente 500 caracteres
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		BigDecimal price = new BigDecimal("25.0");
		int pages = 120;
		String isbn = "Livro1";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("clássico moderno");

		Author fernandoBoaglio = null;
		
		Assert.assertThrows(IllegalArgumentException.class, () -> new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, fernandoBoaglio));	
		}
}
