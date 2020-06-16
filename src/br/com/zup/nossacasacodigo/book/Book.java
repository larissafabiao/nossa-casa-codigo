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
		isEmpty(title, "T�tulo");
	}
	
	private void summaryValidator(String summary) {
		isEmpty(summary, "Sum�rio");
		if (summary.length() > 500) {
			throw new IllegalArgumentException("Tamanho da descri��o maior do que o permitido");
		}
	}
	
	private void priceValidator(Double price) {
		if(price < 20.0) {
			throw new IllegalArgumentException("pre�o menor do que 20 reais n�o permitido");
		}
	}
	
	private void pagesValidator(int pages) {
		if (pages < 100) {
			throw new IllegalArgumentException("o m�nimo de p�ginas � 100");
		}
	}
	
	private void isbnValidator(String ibsn) {
		isEmpty(ibsn, "ibsn");
	}
	
	private void publicationDateValidator(LocalDate publicationDate) {
		LocalDate today = LocalDate.now();
		if (publicationDate.isBefore(today)) {
			throw new IllegalArgumentException("a data de publica��o deve ser no futuro");
		}
	}
	
	public void categoryValidator(Category category) {
		if (category == null) {
			throw new IllegalArgumentException("a categoria n�o pode ser nula");
		}
	}

	private void isEmpty(String string, String paramether) {
		if (string == null) {
			throw new IllegalArgumentException(paramether + " n�o pode ser nula");
		}
		if (string.isEmpty()) {
			throw new IllegalArgumentException(paramether + " n�o pode ser vazia");
		}
		//Verificar se a String n�o possui algum caractere v�lido
		if (string.trim().isEmpty()) {
			throw new IllegalArgumentException(paramether + " n�o precisa possuir caracteres v�lidos");
		}
	}

	public String getIsbn() {
		return isbn;
	}
}
