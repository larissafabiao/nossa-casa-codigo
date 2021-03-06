package br.com.zup.nossacasacodigo.client;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import br.com.zup.nossacasacodigo.auxiliars.CpfValidator;
import br.com.zup.nossacasacodigo.auxiliars.Validators;
import br.com.zup.nossacasacodigo.cart.Cart;
import br.com.zup.nossacasacodigo.purchase.Purchase;

public class Client {
	private static int id = 0;
	private String name;
	private String surname;
	private String email;
	private String cpf;
	private String address;
	private String complement;
	private String city;
	private Map<Integer, Purchase> purchases = new HashMap<>();
	
	
	public Client(String name, String surname,String email, String cpf, String address, String complement, String city) {
		this.name = Validators.checkNull(name, "nome");
		this.surname = Validators.checkNull(surname, "sobrenome");
		this.email = Validators.emailValidator(email);
		this.cpf = CpfValidator.validateCpf(cpf);
		this.address = Validators.checkNull(address, "endere�o");
		this.complement = Validators.checkNull(complement, "complemento");
		this.city = Validators.checkNull(city, "cidade");
	}
	
	public void addPurchase(Purchase purchase) {
		purchases.put(id, purchase);
	}

	public String getCpf() {
		return cpf;
	}
	
	
}
