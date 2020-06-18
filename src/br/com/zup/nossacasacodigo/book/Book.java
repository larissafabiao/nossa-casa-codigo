package br.com.zup.nossacasacodigo.book;

import java.time.LocalDate;
import java.util.Objects;

import br.com.zup.nossacasacodigo.auxiliars.IsEmpty;
import br.com.zup.nossacasacodigo.category.Category;

public class Book {
	private String title;
	private String synopsis;
	private String summary;
	private Double price;
	private int pages;
	private String isbn;
	private LocalDate publicationDate;
	private Category category;
	
	IsEmpty verify = new IsEmpty();

	public Book (String title, String synopsis, String summary, Double price, int pages, String isbn, Category category, LocalDate publicationDate) {

		this.title = titleValidator(title);
		this.synopsis = summaryValidator(synopsis);;
		this.price = priceValidator(price);
		this.pages = pagesValidator(pages);
		this.isbn = isbnValidator(isbn);
		this.publicationDate = publicationDateValidator(publicationDate);
		this.category = categoryValidator(category);
		
	}
	
	private String titleValidator(String title) {
		verify.isEmpty(title, "Título");
		return title.toUpperCase();
	}
	
	private String summaryValidator(String summary) {
		verify.isEmpty(summary, "Sumário");
		if (summary.length() > 500) {
			throw new IllegalArgumentException("Tamanho da descrição maior do que o permitido");
		}
		return summary;
	}
	
	private Double priceValidator(Double price) {
		if(price < 20.0) {
			throw new IllegalArgumentException("preço menor do que 20 reais não permitido");
		}
		return price;
	}
	
	private int pagesValidator(int pages) {
		if (pages < 100) {
			throw new IllegalArgumentException("o mínimo de páginas é 100");
		}
		return pages;
	}
	
	private String isbnValidator(String isbn) {
		verify.isEmpty(isbn, "ibsn");
		return isbn;
	}
	
	private LocalDate publicationDateValidator(LocalDate publicationDate) {
		LocalDate today = LocalDate.now();
		if (publicationDate.isBefore(today)) {
			throw new IllegalArgumentException("a data de publicação deve ser no futuro");
		}
		return publicationDate;
	}
	
	public Category categoryValidator(Category category) {
		Objects.requireNonNull(category, "A categoria não pode ser nula");
		return category;
	}

	public String getIsbn() {
		return isbn;
	}
}
