package br.com.zup.nossacasacodigo.test;

import br.com.zup.nossacasacodigo.controllers.AuthorService;

public class TestMissingDescription {
	public static void main(String[] args) {

		String name = "Larissa Fabião da Fonseca";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "";

		AuthorService service = new AuthorService();

		service.newAuthor(name, email, description);

		service.showAllAuthors();
	}
}
