package com.business.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.business.entities.Product;
import com.business.services.ProductServices;

@Controller
public class ProductController {

	private final ProductServices productServices;

	public ProductController(ProductServices productServices) {
		this.productServices = productServices;
	}

	// AddProduct
	@PostMapping("/addingProduct")
	public String addProduct(@ModelAttribute Product product) {
		this.productServices.addProduct(product);
		return "redirect:/admin/services";
	}

	// UpdateProduct
	@PostMapping("/updatingProduct/{productId}")
	public String updateProduct(@ModelAttribute Product product, @PathVariable("productId") int id) {
		this.productServices.updateproduct(product, id);
		return "redirect:/admin/services";
	}

	// DeleteProduct
	@PostMapping("/deleteProduct/{productId}")
	public String delete(@PathVariable("productId") int id) {
		this.productServices.deleteProduct(id);
		return "redirect:/admin/services";
	}
}
