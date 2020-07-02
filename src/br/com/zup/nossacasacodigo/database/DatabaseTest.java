package br.com.zup.nossacasacodigo.database;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.book.Book;
import br.com.zup.nossacasacodigo.category.Category;

public class DatabaseTest {
	private Database database;
	private Author author;
	private Category category;
	private Book book;
	
	@BeforeEach
	void setup() {
		this.database = new Database();

		String name = "Larissa Fabião da Fonseca";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		this.author = new Author(name, email, description);
		
		this.category = new Category("terror");
		
		String title = "Neuromancer";
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		BigDecimal price = new BigDecimal("30.0");
		int pages = 300;
		String isbn = "Livro 1";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		this.book = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, author);
	}
	
	@Test
	public void testWithOneAutor() {
		Map<String, Author> authors = database.addNewAuthor(author);
		
		Assert.assertTrue(authors.containsValue(author));	
		Assert.assertEquals(authors.size(), 1);
	}
	
	@Test
	public void testWithTwoAuthorsWithDiferentEmails() {
		String nameTwo = "Larissa Fonseca";
		String emailTwo = "larissao@gmail.com";
		//texto de exemplo com menos de 400 caracteres
		String descriptionTwo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci.  Nulla at porttitor turpis.";
		
		Author newAuthorTwo = new Author(nameTwo, emailTwo, descriptionTwo);
		
		Map<String, Author> authors = database.addNewAuthor(author);
		authors = database.addNewAuthor(newAuthorTwo);
		Assert.assertTrue(authors.containsValue(author));	
		Assert.assertTrue(authors.containsValue(newAuthorTwo));
		Assert.assertEquals(authors.get(author.getEmail().toUpperCase()), author);
		Assert.assertEquals(authors.get(emailTwo.toUpperCase()), newAuthorTwo);
		Assert.assertEquals(authors.size(), 2);
	}
	
	@Test
	public void testWithAnEmailPreviouslyCadastredReturningAnException() {
		database.addNewAuthor(author);
		Assertions.assertThrows(IllegalStateException.class, () -> database.addNewAuthor(author));
	}
	
	@Test
	public void searchingForAnAuthorPreviouslyCadastredAndReturningThisAuthor() {
		String nameTwo = "Larissa Fonseca";
		String emailTwo = "larissao@gmail.com";
		//texto de exemplo com menos de 400 caracteres
		String descriptionTwo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci.  Nulla at porttitor turpis.";
		
		Author newAuthorTwo = new Author(nameTwo, emailTwo, descriptionTwo);
		
		database.addNewAuthor(author);
		database.addNewAuthor(newAuthorTwo);
		
		Assert.assertEquals(author, database.searchAuthor(author.getEmail()));
		Assert.assertEquals(newAuthorTwo, database.searchAuthor(emailTwo));
	}
	
	@Test
	public void searchingForAnAuthorNotCadastredAndReturningAIllegalStateException() {
		database.addNewAuthor(author);
		Assert.assertThrows(IllegalStateException.class , () -> database.searchAuthor("larissao@gmail.com"));
	}
	
	@Test
	public void includingAnBookAndReturningASuccessOperation() {
		database.addBookInDatabase(book);
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
				
		Book oPequenoPrincipe = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, author);
		database.addBookInDatabase(oPequenoPrincipe);
		Map<String, Book> books = database.addBookInDatabase(book);
		Assert.assertEquals(books.size(), 2);
	}
	
	@Test
	public void includingTwoBooksWithTheSameIsbnReturningAnIlegalStateException() {
		String title = "O pequeno Principe";
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		BigDecimal price = new BigDecimal("25.0");
		int pages = 120;
		String isbn = "Livro 1";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("clássico moderno");
		
		Book oPequenoPrincipe = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, author);
		database.addBookInDatabase(oPequenoPrincipe);
		Assert.assertThrows(IllegalStateException.class,() -> database.addBookInDatabase(book));
	}
	
	@Test
	public void testeWithOneCategoryWithValidData() {
		Map<String, Category> categories = database.addNewCategory(category);
		Assert.assertEquals(categories.size(), 1);
	}
	
	@Test
	public void testeWithTheInsertionOfTwoCatgoriesWithTheSameName() {
		Category categoryTwo = new Category("Terror");
		
		database.addNewCategory(category);
		
		Assert.assertThrows(IllegalStateException.class, () -> database.addNewCategory(categoryTwo));
	}
	
	@Test
	public void insertTwoDifferentCategoriesAndSearchForThenReturningTheCorrectObject() {
		Category categoryTwo = new Category("ficção científica");
		
		database.addNewCategory(category);
		Map<String, Category> categories = database.addNewCategory(categoryTwo);
		
		Assert.assertEquals(category, database.searchCategory("Terror"));
		Assert.assertEquals(categoryTwo, database.searchCategory("ficção científica"));
	}
	
	@Test
	public void testeToSearchForAnInexistentCategoryReturningAnException() {
		Map<String, Category> categories = database.addNewCategory(category);
		Assert.assertThrows(IllegalStateException.class, () -> database.searchCategory("suspense"));
	}
	
}

