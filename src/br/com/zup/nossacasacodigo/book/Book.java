package br.com.zup.nossacasacodigo.book;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

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
	
	public Book (String title, String synopsis, String summary, BigDecimal price, int pages, String isbn, Category category, LocalDate publicationDate) {

		this.title = IsEmpty.check(title, "T�tulo").toUpperCase();
		this.synopsis = summaryValidator(synopsis);;
		this.price = priceValidator(price);
		this.pages = pagesValidator(pages);
		this.isbn = IsEmpty.check(isbn, "ibsn");;
		this.publicationDate = publicationDateValidator(publicationDate);
		this.category = categoryValidator(category);
		
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	private String summaryValidator(String summary) {
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
	
	private Category categoryValidator(Category category) {
		if (category == null) {
			throw new IllegalArgumentException("a categoria n�o pode ser nula");
		}
		return category;
	}
}
