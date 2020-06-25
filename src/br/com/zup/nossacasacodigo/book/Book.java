package br.com.zup.nossacasacodigo.book;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.auxiliars.IsEmpty;
import br.com.zup.nossacasacodigo.category.Category;

public class Book {
	private String title;
	private String synopsis;
	private String summary;
	private BigDecimal price;
	private int pages;
	private String isbn;
	private LocalDate publicationDate;
	private Category category;
	private Author author;
	
	public Book (String title, String synopsis, String summary, BigDecimal price, int pages, String isbn, Category category, LocalDate publicationDate, Author author) {
		nonNullObjectValidator(category);
		nonNullObjectValidator(author);
		
		this.title = IsEmpty.check(title, "T�tulo").toUpperCase();
		this.synopsis = synopsisValidator(synopsis);
		this.summary = summary;
		this.price = priceValidator(price);
		this.pages = pagesValidator(pages);
		this.isbn = IsEmpty.check(isbn, "ibsn");
		this.publicationDate = publicationDateValidator(publicationDate);
		this.category = category;
		this.author = author;
	}
	
	private String synopsisValidator(String summary) {
		IsEmpty.check(summary, "Sum�rio");
		if (summary.length() > 500) {
			throw new IllegalArgumentException("Tamanho da descri��o maior do que o permitido");
		}
		return summary;
	}
	
	private BigDecimal priceValidator(BigDecimal price) {
		if(price.doubleValue() < 20.0) {
			throw new IllegalArgumentException("pre�o menor do que 20 reais n�o permitido");
		}
		return price;
	}
	
	private int pagesValidator(int pages) {
		if (pages < 100) {
			throw new IllegalArgumentException("o m�nimo de p�ginas � 100");
		}
		return pages;
	}
	
	private LocalDate publicationDateValidator(LocalDate publicationDate) {
		LocalDate today = LocalDate.now();
		if (publicationDate.isBefore(today)) {
			throw new IllegalArgumentException("a data de publica��o deve ser no futuro");
		}
		return publicationDate;
	}
	
	private void nonNullObjectValidator(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("a categoria n�o pode ser nula");
		}
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}

	public BookDetail getBookDetail() {
		return new BookDetail(this.title, this.synopsis, this.summary, this.price, this.pages, this.isbn, this.author);
	}
}