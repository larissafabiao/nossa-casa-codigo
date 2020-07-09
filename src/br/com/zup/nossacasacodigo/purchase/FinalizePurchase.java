package br.com.zup.nossacasacodigo.purchase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;


import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.book.Book;
import br.com.zup.nossacasacodigo.cart.Cart;
import br.com.zup.nossacasacodigo.category.Category;
import br.com.zup.nossacasacodigo.client.Client;
import br.com.zup.nossacasacodigo.database.PurchaseDatabase;



public class FinalizePurchase {
	int id = 0;
	static PurchaseDatabase db = new PurchaseDatabase();
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

		Cart cart = new Cart();
		
		cart.addToCart(pequenoPrincipe, 1);
		cart.addToCart(springBoot, 1);
		
		LocalDateTime expirationDate = LocalDateTime.of(2020, 10, 1, 23, 59);
		DiscountCoupon less10 = new DiscountCoupon("LESS10", expirationDate, new BigDecimal("0.1"));
		db.addNewCoupon(less10);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Email: ");
		String cientEmail = sc.nextLine();
		System.out.println("Nome: ");
		String clientName = sc.nextLine();
		System.out.println("Sobrenome: ");
		String surname = sc.nextLine();
		System.out.println("CPF/CNPJ:(somente números) ");
		String cpf = sc.nextLine();
		System.out.println("Endereço(com número): ");
		String address = sc.nextLine();
		System.out.println("Casa, apartamento, etc: ");
		String complement = sc.nextLine();
		System.out.println("Cidade: ");
		String city = sc.nextLine();
		System.out.println("Cupom de desconto: ");
		Optional<String> coupon = Optional.ofNullable(sc.nextLine());
	
		Optional<Client> verifyClient = db.seachClient(cpf);
		Client client;
		if(verifyClient.isEmpty()) {
			client = new Client(clientName, surname, cientEmail, cpf, address, complement, city);
			db.addNewClient(client);
		} else {
			client = verifyClient.get();
		}
		Optional<DiscountCoupon> discount = db.searchCoupon(coupon.get());
		int id = client.addPurchase(cart);
		System.out.println("id da compra: " + id + ",   valor final: " + cart.calculateFinalValue(discount));
	}
}
