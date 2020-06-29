package br.com.zup.nossacasacodigo.auxiliars;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Optional;
import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.book.Book;
import br.com.zup.nossacasacodigo.category.Category;
import br.com.zup.nossacasacodigo.database.CollectionsValidatorsAndGetters;
import br.com.zup.nossacasacodigo.database.Database;

public class ShowABook {
	public static void main(String[] args) {
		String title = "Spring Boot";
		String synopsis = "Descrição do livro";
		String summary = "Acelere o desenvolvimento de microsserviços";
		BigDecimal price = new BigDecimal("29.9");
		int pages = 154;
		String isbn = "978-85-94120-00-7";
		LocalDate publicationDate = LocalDate.of(2020,8,16);
		Category category = new Category("clássico moderno");
		
		String name = "Fernando Boaglio";
		String email = "larissafabiao@gmail.com";
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
		
		Author fernandoBoaglio = new Author(name, email, description);
		
		Book springBoot = new Book(title, synopsis, summary, price, pages, isbn, category, publicationDate, fernandoBoaglio);
		Database database = new Database();
		
		Optional<Book> bookReturned = CollectionsValidatorsAndGetters.searchBook("Spring Boot", database.addBookInDatabase(springBoot));
		
		//formatação para impressão do valor baseado na locaçização geográfica
		if (bookReturned.isPresent()) {
			Book book = bookReturned.get();
			System.out.println(book.getTitle());
			System.out.println(book.getAuthor().getName());
			System.out.println(NumberFormat.getCurrencyInstance().format(book.getPrice()));
			System.out.println("Conteúdo: ");
			System.out.println(book.getSynopsis());
			System.out.println("Sumário: ");
			System.out.println(book.getSummary());
			System.out.println(book.getPages());
			System.out.println(book.getIsbn());
		} else {
			System.out.println("Livro não encontrado");
		}
	}
}
