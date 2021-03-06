package br.com.zup.nossacasacodigo.cart;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Optional;

import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.book.Book;
import br.com.zup.nossacasacodigo.category.Category;
import br.com.zup.nossacasacodigo.database.Database;

public class ShowCart {
	static Database database = new Database();
	
	public static void main(String[] args) {
		String name = "Fernando Boaglio";
		String email = "larissafabiao@gmail.com";
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		Author fernandoBoaglio = new Author(name, email, description);
		
		String title = "Spring Boot";
		String synopsis = "Descri��o do livro";
		String summary = "Acelere o desenvolvimento de microsservi�os";
		BigDecimal price = new BigDecimal("29.9");
		int pages = 154;
		String isbn = "978-85-94120-00-7";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("cl�ssico moderno");
		
		Book springBoot = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, fernandoBoaglio);
		Book springBoot2 = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, fernandoBoaglio);
		title = "O pequeno Principe";
		synopsis = "descri��o livro 2";
		summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		price = new BigDecimal("30.0");
		pages = 100;
		isbn = "Livro1";
		publicationDate = LocalDate.of(2020,8,16);
		category = new Category("cl�ssico moderno");

		Book pequenoPrincipe = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, fernandoBoaglio);
	
		Cart cart = new Cart();
		
		cart.addToCart(pequenoPrincipe, 1);
		cart.addToCart(springBoot, 1);
		cart.addToCart(springBoot2, 2);
		
		//formata��o para impress�o do valor baseado na loca�iza��o geogr�fica, com a quantidade pr� definida como 1 at� ser necess�rio alterara
		System.out.format("%2s%40s%25s%25s\n", "ITENS", "PRE�O", "QUANTIDADE", "TOTAL");		
		for (CartItem item : cart.getCartItems()) {
			Book book = item.getBook();
			System.out.format("%2s%30s%30s%30s\n", book.getTitle(), NumberFormat.getCurrencyInstance().format(book.getPrice()), item.getQuantity(), NumberFormat.getCurrencyInstance().format(book.getPrice()));
		}
		System.out.println("Valor final: " + NumberFormat.getCurrencyInstance().format(cart.calculateFinalValue()));
	}
}
