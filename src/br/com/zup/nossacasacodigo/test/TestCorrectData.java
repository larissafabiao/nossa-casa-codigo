package br.com.zup.nossacasacodigo.test;

import br.com.zup.nossacasacodigo.controllers.AuthorService;

public class TestCorrectData {

	public static void main(String[] args) {
		String name = "Larissa Fabião da Fonseca";
		String email = "larissafabiao@gmail.com";
		//texto de exemplo com exatamente 400 caracteres
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin et placerat purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque vulputate libero tortor. Fusce arcu felis, rhoncus eget est in, suscipit venenatis orci. Vestibulum eget feugiat justo. Morbi sit amet felis finibus, imperdiet metus eget, pellentesque risus. Nulla at porttitor turpis.";
	
		AuthorService service = new AuthorService();
		
		service.newAuthor(name, email, description);
		
		service.showAllAuthors();
	}

}
