package br.com.zup.nossacasacodigo.book;

import java.math.BigDecimal;

import br.com.zup.nossacasacodigo.author.Author;

public class BookDetail {
	private String title;
	private String synopsis;
	private String summary;
	private BigDecimal price;
	private int pages;
	private String isbn;
	private Author author;
	
	public BookDetail (String title, String synopsis, String summary, BigDecimal price, int pages, String isbn, Author author) {
		this.title = title;
		this.synopsis = synopsis;
		this.summary = summary;
		this.price = price;
		this.pages = pages;
		this.isbn = isbn;

		this.author = author;
	}
	
	//Fun��o de imprimir o livro simples, considerando o pre�o em reais. Para poss�veis novas regras de neg�cio dever�o ser adicionadas novas formas de impress�o.
	public void printBookInfo () {
		System.out.println(this.title);
		System.out.println(this.author.getName());
		System.out.println("R$ " + this.price);
		System.out.println("Conte�do: ");
		System.out.println(this.synopsis);
		System.out.println("Sum�rio: ");
		System.out.println(this.summary);
		System.out.println(this.pages);
		System.out.println(this.isbn);
	}
}
