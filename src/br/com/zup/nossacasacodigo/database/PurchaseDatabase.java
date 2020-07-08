package br.com.zup.nossacasacodigo.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import br.com.zup.nossacasacodigo.cart.DiscountCoupon;
import br.com.zup.nossacasacodigo.client.Client;

public class PurchaseDatabase {
	private Map<String, Client> clients =  new HashMap<>();
	private Map<String, DiscountCoupon> coupons =  new HashMap<>();
	
	public Optional<Client> seachClient(String cpf) {
		Optional<Client> wanted = DatabaseAuxiliars.searchInDatabase(cpf, clients);
		return wanted;
	}
	
	public void addNewCoupon(DiscountCoupon coupon) {
		DatabaseAuxiliars.checkIfIsUnic(coupon.getDiscountCode(), coupons);
		coupons.put(coupon.getDiscountCode(), coupon);
	}
	
	public Optional<DiscountCoupon> searchCoupon(String code) {
		return  DatabaseAuxiliars.searchInDatabase(code, coupons);
	}
}