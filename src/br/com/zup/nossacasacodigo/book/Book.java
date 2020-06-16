package br.com.zup.nossacasacodigo.book;

import java.time.LocalDate;

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
	
	public Book (String title, String synopsis, String summary, Double price, int pages, String isbn, Category category, LocalDate publicationDate) {
		titleValidator(title);
		summaryValidator(synopsis);
		priceValidator(price);
		pagesValidator(pages);
		isbnValidator(isbn);
		publicationDateValidator(publicationDate);
		categoryValidator(category);
		
		this.title = title.toUpperCase();
		this.synopsis = synopsis;
		this.price = price;
		this.pages = pages;
		this.isbn = isbn;
		this.publicationDate = publicationDate;
		this.category = category;
		
	}
	
	private void titleValidator(String title) {
		isEmpty(title, "Título");
	}
	
	private void summaryValidator(String summary) {
		isEmpty(summary, "Sumário");
		if (summary.length() > 500) {
			throw new IllegalArgumentException("Tamanho da descrição maior do que o permitido");
		}
	}
	
	private void priceValidator(Double price) {
		if(price < 20.0) {
			throw new IllegalArgumentException("preço menor do que 20 reais não permitido");
		}
	}
	
	private void pagesValidator(int pages) {
		if (pages < 100) {
			throw new IllegalArgumentException("o mínimo de páginas é 100");
		}
	}
	
	private void isbnValidator(String ibsn) {
		isEmpty(ibsn, "ibsn");
	}
	
	private void publicationDateValidator(LocalDate publicationDate) {
		LocalDate today = LocalDate.now();
		if (publicationDate.isBefore(today)) {
			throw new IllegalArgumentException("a data de publicação deve ser no futuro");
		}
	}
	
	public void categoryValidator(Category category) {
		if (category == null) {
			throw new IllegalArgumentException("a categoria não pode ser nula");
		}
	}

	private void isEmpty(String string, String paramether) {
		if (string == null) {
			throw new IllegalArgumentException(paramether + " não pode ser nula");
		}
		if (string.isEmpty()) {
			throw new IllegalArgumentException(paramether + " não pode ser vazia");
		}
		//Verificar se a String não possui algum caractere válido
		if (string.trim().isEmpty()) {
			throw new IllegalArgumentException(paramether + " não precisa possuir caracteres válidos");
		}
	}

	public String getIsbn() {
		return isbn;
	}
}
