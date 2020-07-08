package br.com.zup.nossacasacodigo.cart;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.book.Book;
import br.com.zup.nossacasacodigo.category.Category;
import br.com.zup.nossacasacodigo.cart.DiscountCoupon;

public class CartTest {
	Book book;
	Author author;
	Category category;
	
	@BeforeEach
	void setup() {
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
	public void testCreatingACart() {
		Cart cart = new Cart();
	}
	
	@Test
	public void testCreatingACartWithValidInformationReturningTheCorrectFinalPrice() {
		Cart cart = new Cart();
		cart.addToCart(book, 2);
		Assert.assertEquals(new BigDecimal("60.0"), cart.calculateFinalValue(Optional.empty()));
	}
	
	@Test
	public void testCreatingACartWithInvalidNunberOfBooksReturningAnException() {
		Cart cart = new Cart();
		Assertions.assertThrows(IllegalArgumentException.class,() -> cart.addToCart(book, 0));
	}
	public void testCreatingACartWithTwoEqualBooksWithMoreThanOneInsertionReturningTheCorrectFinalPriceAndQuantity() {
		Cart cart = new Cart();
		cart.addToCart(book, 2);
		cart.addToCart(book, 2);
		Assert.assertEquals(new BigDecimal("120.0"), cart.calculateFinalValue(Optional.empty()));
		for (CartItem item : cart.getCart()) {
			Assert.assertEquals(4, item.getQuantity());
		}
	}
}
