package br.com.zup.nossacasacodigo.book;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.zup.nossacasacodigo.author.Author;
import br.com.zup.nossacasacodigo.auxiliars.Validators;
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
		
		this.title = Validators.checkNull(title, "Título").toUpperCase();
		this.synopsis = synopsisValidator(synopsis);
		this.summary = summary;
		this.price = priceValidator(price);
		this.pages = pagesValidator(pages);
		this.isbn = Validators.checkNull(isbn, "ibsn");
		this.publicationDate = publicationDateValidator(publicationDate);
		this.category = category;
		this.author = author;
	}
	
	private String synopsisValidator(String summary) {
		Validators.checkNull(summary, "Sumário");
		if (summary.length() > 500) {
			throw new IllegalArgumentException("Tamanho da descrição maior do que o permitido");
		}
		return summary;
	}
	
	private BigDecimal priceValidator(BigDecimal price) {
		if(price.doubleValue() < 20.0) {
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
	
	private LocalDate publicationDateValidator(LocalDate publicationDate) {
		LocalDate today = LocalDate.now();
		if (publicationDate.isBefore(today)) {
			throw new IllegalArgumentException("a data de publicação deve ser no futuro");
		}
		return publicationDate;
	}
	
	private <T> T nonNullObjectValidator(T obj) {
		if (obj == null) {
			throw new IllegalArgumentException("a categoria não pode ser nula");
		}
		return obj;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public String getSummary() {
		return summary;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getPages() {
		return pages;
	}

	public Author getAuthor() {
		return author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	
	
}