package br.com.zup.nossacasacodigo.test;

import br.com.zup.nossacasacodigo.controllers.AuthorService;

public class TestInvalidDescription {
	public static void main(String[] args) {
		String name = "Larissa Fabião da Fonseca";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 500 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean luctus vestibulum lectus, eu tempus nisi ornare eget. Etiam interdum porta neque, volutpat feugiat lacus ultrices ac. Nulla a mi id mauris tempus porta. Curabitur sed augue id sem sollicitudin accumsan id eu velit. Morbi fermentum ligula at mauris tincidunt, quis tincidunt mauris facilisis. Ut in risus sed ante convallis consectetur. Nulla nec libero odio. Integer feugiat, est hendrerit congue consequat, augue massa posuere posuere.";
	
		AuthorService service = new AuthorService();
		
		service.newAuthor(name, email, description);
		
		service.showAllAuthors();
	}
}
