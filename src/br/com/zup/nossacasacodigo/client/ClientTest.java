package br.com.zup.nossacasacodigo.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientTest {
	@Test
	public void testCreatingANewClientReturningASuccessOperation() {
		String name = "Larissa";
		String surname = "Fonseca";
		String email = "larissa@gmail.com";
		String cpf = "49669162831";
		String address = "Rua exemplo, numero 00";
		String complement = "casa";
		String city = "São Paulo";
		Client client  = new Client(name, surname, email, cpf, address, complement, city);
	}
	
	@Test
	public void testCreatingANewClientWithAnInvalidCPFReturningAnException() {
		String name = "Larissa";
		String surname = "Fonseca";
		String email = "larissa@gmail.com";
		String cpf = "12345678910";
		String address = "Rua exemplo, numero 00";
		String complement = "casa";
		String city = "São Paulo";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Client(name, surname, email, cpf, address, complement, city));
	}
	
	@Test
	public void testCreatingANewClientWithAnInvalidNameReturningAnException() {
		String name = "";
		String surname = "Fonseca";
		String email = "larissa@gmail.com";
		String cpf = "49669162831";
		String address = "Rua exemplo, numero 00";
		String complement = "casa";
		String city = "São Paulo";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Client(name, surname, email, cpf, address, complement, city));
	}
	
	@Test
	public void testCreatingANewClientWithAnNullCPFReturningAnException() {
		String name = "";
		String surname = "Fonseca";
		String email = "larissa@gmail.com";
		String cpf = null;
		String address = "Rua exemplo, numero 00";
		String complement = "casa";
		String city = "São Paulo";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Client(name, surname, email, cpf, address, complement, city));
	}
	
	@Test
	public void testCreatingANewClientWithAnInvalidSurnameReturningAnException() {
		String name = "Larissa";
		String surname = "";
		String email = "larissa@gmail.com";
		String cpf = "49669162831";
		String address = "Rua exemplo, numero 00";
		String complement = "casa";
		String city = "São Paulo";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Client(name, surname, email, cpf, address, complement, city));
	}
	
	@Test
	public void testCreatingANewClientWithAnInvalidEmailReturningAnException() {
		String name = "Larissa";
		String surname = "Fonseca";
		String email = "larissa";
		String cpf = "49669162831";
		String address = "Rua exemplo, numero 00";
		String complement = "casa";
		String city = "São Paulo";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Client(name, surname, email, cpf, address, complement, city));
	}
	
	@Test
	public void testCreatingANewClientWithAnInvalidAddressReturningAnException() {
		String name = "Larissa";
		String surname = "Fonseca";
		String email = "larissa";
		String cpf = "49669162831";
		String address = "";
		String complement = "casa";
		String city = "São Paulo";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Client(name, surname, email, cpf, address, complement, city));
	}
	
	@Test
	public void testCreatingANewClientWithAnInvalidComplementReturningAnException() {
		String name = "";
		String surname = "Fonseca";
		String email = "larissa@gmail.com";
		String cpf = "49669162831";
		String address = "Rua exemplo, numero 00";
		String complement = "";
		String city = "São Paulo";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Client(name, surname, email, cpf, address, complement, city));
	}
	
	@Test
	public void testCreatingANewClientWithAnInvalidCityReturningAnException() {
		String name = "";
		String surname = "Fonseca";
		String email = "larissa@gmail.com";
		String cpf = "49669162831";
		String address = "Rua exemplo, numero 00";
		String complement = "casa";
		String city = "";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Client(name, surname, email, cpf, address, complement, city));
	}
}
