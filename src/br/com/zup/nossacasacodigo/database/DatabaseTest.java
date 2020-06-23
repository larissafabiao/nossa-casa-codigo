package br.com.zup.nossacasacodigo.database;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.book.Book;
import br.com.zup.nossacasacodigo.category.Category;

public class DatabaseTest {
	@Test
	public void testWithOneAutor() {
		String name = "Larissa Fabião da Fonseca";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";

		Database database = new Database();
		
		Author newAuthorOne = new Author(name, email, description);
		
		Map<String, Author> authors;
		authors = database.addNewAuthor(newAuthorOne);
		
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
		
		Database database = new Database();
		
		Author newAuthorOne = new Author(name, email, description);
		Author newAuthorTwo = new Author(nameTwo, emailTwo, descriptionTwo);
		
		Map<String, Author> authors = database.addNewAuthor(newAuthorOne);
		authors = database.addNewAuthor(newAuthorTwo);
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
		
		Database database = new Database();
		
		Author newAuthorOne = new Author(name, email, description);
		Author newAuthorTwo = new Author(nameTwo, emailTwo, descriptionTwo);
		
		database.addNewAuthor(newAuthorOne);
		Assertions.assertThrows(IllegalStateException.class, () -> database.addNewAuthor(newAuthorTwo));
	}
	
	@Test
	public void searchingForAnAuthorPreviouslyCadastredAndReturningThisAuthor() {
		String name = "Larissa Fabião da Fonseca";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		String nameTwo = "Larissa Fonseca";
		String emailTwo = "larissao@gmail.com";
		//texto de exemplo com menos de 400 caracteres
		String descriptionTwo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci.  Nulla at porttitor turpis.";
		
		Database database = new Database();
		
		Author newAuthorOne = new Author(name, email, description);
		Author newAuthorTwo = new Author(nameTwo, emailTwo, descriptionTwo);
		database.addNewAuthor(newAuthorOne);
		database.addNewAuthor(newAuthorTwo);
		
		Assert.assertEquals(newAuthorTwo, database.searchAuthor(emailTwo));
	}
	
	@Test
	public void searchingForAnAuthorNotCadastredAndReturningAIllegalStateException() {
		String name = "Larissa Fabião da Fonseca";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
				
		Database database = new Database();
		
		Author newAuthorOne = new Author(name, email, description);
		
		database.addNewAuthor(newAuthorOne);
		
		Assert.assertThrows(IllegalStateException.class, () -> database.searchAuthor("larissao@gmail.com"));
	}
	
	@Test
	public void includingAnBookAndReturningASuccessOperation() {
		String title = "O pequeno Principe";
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		BigDecimal price = new BigDecimal("25.0");
		int pages = 120;
		String isbn = "Livro1";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("clássico moderno");
		
		Book oPequenoPrincipe = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate);
		Database database = new Database();
		Map<String, Book> books = database.addBookInDatabase(oPequenoPrincipe);
		
		Assert.assertTrue(books.containsKey(isbn));
	}
	
	@Test
	public void includingTwoBooksReturingASucessfullOperation() {
		String title = "O pequeno Principe";
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		BigDecimal price = new BigDecimal("25.0");
		int pages = 120;
		String isbn = "Livro1";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("clássico moderno");
		
		String title2 = "Neuromancer";
		String synopsis2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary2 = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		BigDecimal price2 = new BigDecimal("30.0");
		int pages2 = 300;
		String isbn2 = "Livro2";
		LocalDate publicationDate2 = LocalDate.of(2020,8,16);
		Category category2 = new Category("futurista");
		
		Book oPequenoPrincipe = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate);
		Book neuromancer = new Book(title2, synopsis2, summary2, price2, pages2, isbn2, category2, publicationDate2);
		Database database = new Database();
		database.addBookInDatabase(oPequenoPrincipe);
		Map<String, Book> books = database.addBookInDatabase(neuromancer);
		Assert.assertEquals(books.size(), 2);
	}
	
	@Test
	public void includingTwoBooksWithTheSameIsbnReturningAnIlegalStateException() {
		String title = "O pequeno Principe";
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		BigDecimal price = new BigDecimal("25.0");
		int pages = 120;
		String isbn = "Livro1";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("clássico moderno");
		
		String title2 = "Neuromancer";
		String synopsis2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary2 = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		BigDecimal price2 = new BigDecimal("30.0");
		int pages2 = 300;
		String isbn2 = "Livro1";
		LocalDate publicationDate2 = LocalDate.of(2020,8,16);
		Category category2 = new Category("futurista");
		
		Book oPequenoPrincipe = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate);
		Book neuromancer = new Book(title2, synopsis2, summary2, price2, pages2, isbn2, category2, publicationDate2);
		
		Database database = new Database();
		database.addBookInDatabase(oPequenoPrincipe);
		Assert.assertThrows(IllegalStateException.class,() -> database.addBookInDatabase(neuromancer));
	}
	
	@Test
	public void testeWithOneCategoryWithValidData() {
		Database database = new Database();
		Category categoryCreted = new Category("terror");
		
		Map<String, Category> categories = database.addNewCategory(categoryCreted);
		Assert.assertEquals(categories.size(), 1);
	}
	
	@Test
	public void testeWithTheInsertionOfTwoCatgoriesWithTheSameName() {
		Database database = new Database();
		Category categoryOne = new Category("terror");
		Category categoryTwo = new Category("Terror");
		
		database.addNewCategory(categoryOne);
		
		Assert.assertThrows(IllegalStateException.class, () -> database.addNewCategory(categoryTwo));
	}
	
	@Test
	public void insertTwoDifferentCategoriesAndSearchForThenReturningTheCorrectObject() {
		Database database = new Database();
		Category categoryOne = new Category("terror");
		Category categoryTwo = new Category("ficção científica");
		
		database.addNewCategory(categoryOne);
		database.addNewCategory(categoryTwo);
		
		Assert.assertEquals(categoryOne, database.searchCategory("Terror"));
		Assert.assertEquals(categoryTwo, database.searchCategory("ficção científica"));
	}
	
	@Test
	public void testeToSearchForAnInexistentCategoryReturningAnException() {
		Database database = new Database();
		Category categoryOne = new Category("terror");
		
		database.addNewCategory(categoryOne);
		
		Assert.assertThrows(IllegalStateException.class, () -> database.searchCategory("suspense"));
	}
	
}

