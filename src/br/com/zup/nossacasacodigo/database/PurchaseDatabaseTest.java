package br.com.zup.nossacasacodigo.database;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import br.com.zup.nossacasacodigo.client.Client;
import br.com.zup.nossacasacodigo.purchase.DiscountCoupon;

public class PurchaseDatabaseTest {
		private PurchaseDatabase database;
		private DiscountCoupon coupon;
		private Client client;
		
		@BeforeEach
		void setup() {
			database = new PurchaseDatabase();
			String name = "Larissa";
			String surname = "Fonseca";
			String cpf = "49669162831";
			String email = "larissa@gmail.com";
			String address = "new address, number 00";
			String complement = "casa";
			String city = "São Paulo";
			this.client = new Client(name, surname, email, cpf, address, complement, city);
						
			String discountCode = "ZUP";
			LocalDateTime expirationDate = LocalDateTime.of(2020, 10, 1, 23, 59);
			BigDecimal disount = new BigDecimal("0.1");
			this.coupon = new DiscountCoupon(discountCode, expirationDate, disount);
		}
		
		@Test
		public void testInsertingANewCouponInDatabaseAndReturningASucessOperation() {
			database.addNewCoupon(coupon);
			Assert.assertEquals(database.searchCoupon("ZUP").get(), coupon);
		}
		
		@Test
		public void testInsertingTwoCouponsWithTheSameCodeReturningAnException() {
			database.addNewCoupon(coupon);
			Assertions.assertThrows(IllegalStateException.class,() -> database.addNewCoupon(coupon));
		}
		
		@Test
		public void testInsertingANewClientInDatabaseAndReturningASucessOperation() {
			database.addNewClient(client);
			Assert.assertEquals(database.seachClient("49669162831").get(), client);
		}
		
		@Test
		public void testInsertingTwoClientsWithTheSameCPFAndReturningAnException() {
			database.addNewClient(client);
			Assertions.assertThrows(IllegalStateException.class, () -> database.addNewClient(client));
		}
}
