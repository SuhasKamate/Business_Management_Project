package com.business.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.business.entities.Product;
import com.business.services.ProductServices;

@Controller
public class HomeController {

	private final ProductServices productServices;

	public HomeController(ProductServices productServices) {
		this.productServices = productServices;
	}

	@GetMapping({"/", "/home"})
	public String home() {
		return "Home";
	}

	@GetMapping("/products")
	public String products(Model model) {
		List<Product> allProducts = this.productServices.getAllProducts();
		model.addAttribute("products", allProducts);
		return "Products";
	}

	@GetMapping("/location")
	public String location() {
		return "Locate_us";
	}

	@GetMapping("/about")
	public String about() {
		return "About";
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}
}
