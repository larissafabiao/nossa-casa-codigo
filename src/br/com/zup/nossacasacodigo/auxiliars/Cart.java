package br.com.zup.nossacasacodigo.auxiliars;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.book.Book;
import br.com.zup.nossacasacodigo.category.Category;
import br.com.zup.nossacasacodigo.database.Database;

public class Cart {
	private static List<Book> cart = new ArrayList<Book>();
	private static BigDecimal finalPrice = new BigDecimal(0);
	static Database database = new Database();

	
	public static void main(String[] args) {
		String name = "Fernando Boaglio";
		String email = "larissafabiao@gmail.com";
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		Author fernandoBoaglio = new Author(name, email, description);
		
		String title = "Spring Boot";
		String synopsis = "Descrição do livro";
		String summary = "Acelere o desenvolvimento de microsserviços";
		BigDecimal price = new BigDecimal("29.9");
		int pages = 154;
		String isbn = "978-85-94120-00-7";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("clássico moderno");
		
		Book springBoot = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, fernandoBoaglio);
		
		title = "O pequeno Principe";
		synopsis = "descrição livro 2";
		summary = "It's very easy to make some words **bold** and other words *italic* with Markdown.";
		price = new BigDecimal("30.0");
		pages = 100;
		isbn = "Livro1";
		publicationDate = LocalDate.of(2020,8,16);
		category = new Category("clássico moderno");

		Book pequenoPrincipe = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, fernandoBoaglio);
		database.addBookInDatabase(pequenoPrincipe);
		database.addBookInDatabase(springBoot);
		
		addToCart("O pequeno Principe");
		addToCart("Spring Boot");

		
		//formatação para impressão do valor baseado na locaçização geográfica, com a quantidade pré definida como 1 até ser necessário alterara
		System.out.format("%2s%40s%25s%25s\n", "ITENS", "PREÇO", "QUANTIDADE", "TOTAL");
		for (Book book : cart) {
			System.out.format("%2s%30s%30s%30s\n", book.getTitle(), NumberFormat.getCurrencyInstance().format(book.getPrice()), 1, NumberFormat.getCurrencyInstance().format(book.getPrice()));
			finalPrice = finalPrice.add(book.getPrice());
		}
		System.out.println("Valor final: " + NumberFormat.getCurrencyInstance().format(finalPrice));
	}
	
	private static void addToCart(String wanted) {
		Optional<Book> bookReturned = database.seachBook(wanted);
		if (bookReturned.isPresent()) {
			Book book = bookReturned.get();
			cart.add(book);
		} else {
			System.out.println("Livro não encontrado");
		}
	}
}
