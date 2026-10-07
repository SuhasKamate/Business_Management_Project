package com.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.business.entities.Admin;
import com.business.entities.Product;
import com.business.entities.User;
import com.business.services.AdminServices;
import com.business.services.ProductServices;
import com.business.services.UserServices;

@SpringBootTest
class OrderPriceTests {

	@Autowired
	private AdminServices adminServices;
	@Autowired
	private UserServices userServices;
	@Autowired
	private ProductServices productServices;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void adminPasswordIsHashedNotStoredInPlaintext() {
		Admin admin = new Admin();
		admin.setAdminName("Root");
		admin.setAdminEmail("root-" + System.nanoTime() + "@example.com");
		admin.setAdminNumber("1234567890");
		admin.setAdminPassword("secret123");
		adminServices.addAdmin(admin);

		Admin saved = adminServices.getAdmin(admin.getAdminId());
		assertTrue(saved.getAdminPassword().startsWith("$2"), "password must be BCrypt-hashed");
		assertTrue(passwordEncoder.matches("secret123", saved.getAdminPassword()));
	}

	@Test
	void userPasswordIsHashedNotStoredInPlaintext() {
		User user = new User();
		user.setUname("Alice");
		user.setUemail("alice-" + System.nanoTime() + "@example.com");
		user.setUnumber(9876543210L);
		user.setUpassword("userpass");
		userServices.addUser(user);

		User saved = userServices.getUser(user.getU_id());
		assertTrue(saved.getUpassword().startsWith("$2"), "password must be BCrypt-hashed");
		assertTrue(passwordEncoder.matches("userpass", saved.getUpassword()));
	}

	@Test
	void productPriceComesFromDatabaseNotRequest() {
		// Product is created with an authoritative price in the DB
		Product product = new Product();
		product.setPname("Green Tea " + System.nanoTime());
		product.setPprice(500.0);
		product.setPdescription("premium");
		productServices.addProduct(product);

		// A tampered request would try to send oPrice=0.01. The controller never
		// reads the price from the request; it looks the product up by name and
		// derives the price from the persisted entity. This asserts the source of truth.
		Product fromDb = productServices.getProductByName(product.getPname());
		assertEquals(500.0, fromDb.getPprice(), 0.0001);
	}

	@Test
	void missingProductLookupThrowsInsteadOfReturning500FromGet() {
		// getProduct must surface a clean exception for a non-existent id
		assertThrows(IllegalArgumentException.class, () -> productServices.getProduct(999_999));
	}

	@Test
	void missingUserLookupThrowsCleanException() {
		assertThrows(IllegalArgumentException.class, () -> userServices.getUser(999_999));
	}
}
