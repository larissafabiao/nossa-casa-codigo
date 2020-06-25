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
	
	//Função de imprimir o livro simples, considerando o preço em reais. Para possíveis novas regras de negócio deverão ser adicionadas novas formas de impressão.
	public void printBookInfo () {
		System.out.println(this.title);
		System.out.println(this.author.getName());
		System.out.println("R$ " + this.price);
		System.out.println("Conteúdo: ");
		System.out.println(this.synopsis);
		System.out.println("Sumário: ");
		System.out.println(this.summary);
		System.out.println(this.pages);
		System.out.println(this.isbn);
	}
}
