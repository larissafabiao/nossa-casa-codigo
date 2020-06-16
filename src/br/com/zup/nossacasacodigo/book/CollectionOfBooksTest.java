package br.com.zup.nossacasacodigo.book;

import java.time.LocalDate;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.zup.nossacasacodigo.category.Category;

public class CollectionOfBooksTest {
	@Test
	public void includingAnBookAndReturningASuccessOperation() {
		String title = "O pequeno Principe";
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		Double price = 25.0;
		int pages = 120;
		String isbn = "Livro1";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("clássico moderno");
		
		Book oPequenoPrincipe = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate);
		CollectionOfBooks books = new CollectionOfBooks();
		Map<String, Book> bookList = books.addBookInDatabase(oPequenoPrincipe);
		
		Assert.assertTrue(bookList.containsKey(isbn));
	}
	
	@Test
	public void includingTwoBooksReturingASucessfullOperation() {
		String title = "O pequeno Principe";
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		Double price = 25.0;
		int pages = 120;
		String isbn = "Livro1";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("clássico moderno");
		
		String title2 = "Neuromancer";
		String synopsis2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary2 = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		Double price2 = 30.0;
		int pages2 = 300;
		String isbn2 = "Livro2";
		LocalDate publicationDate2 = LocalDate.of(2020,8,16);
		Category category2 = new Category("futurista");
		
		Book oPequenoPrincipe = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate);
		Book neuromancer = new Book(title2, synopsis2, summary2, price2, pages2, isbn2, category2, publicationDate2);
		CollectionOfBooks books = new CollectionOfBooks();
		books.addBookInDatabase(oPequenoPrincipe);
		Map<String, Book> bookList = books.addBookInDatabase(neuromancer);
		Assert.assertEquals(bookList.size(), 2);
	}
	
	@Test
	public void includingTwoBooksWithTheSameIsbnReturningAnIlegalStateException() {
		String title = "O pequeno Principe";
		String synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		Double price = 25.0;
		int pages = 120;
		String isbn = "Livro1";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("clássico moderno");
		
		String title2 = "Neuromancer";
		String synopsis2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas congue sollicitudin fermentum. Morbi maximus urna sed aliquet condimentum. Suspendisse porta aliquam lacus. Integer faucibus hendrerit sapien. Duis quis efficitur sapien, in sollicitudin sapien. Nunc luctus sit amet odio eget euismod. Maecenas quis interdum nisl. Nullam lectus augue, vestibulum quis nisi nec, sollicitudin mollis magna. Donec faucibus rhoncus lorem, tincidunt pulvinar augue vulputate nec. Pellentesque ornare morbi.";
		String summary2 = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		Double price2 = 30.0;
		int pages2 = 300;
		String isbn2 = "Livro1";
		LocalDate publicationDate2 = LocalDate.of(2020,8,16);
		Category category2 = new Category("futurista");
		
		Book oPequenoPrincipe = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate);
		Book neuromancer = new Book(title2, synopsis2, summary2, price2, pages2, isbn2, category2, publicationDate2);
		CollectionOfBooks books = new CollectionOfBooks();
		books.addBookInDatabase(oPequenoPrincipe);
		Assert.assertThrows(IllegalStateException.class,() -> books.addBookInDatabase(neuromancer));
	}
}
