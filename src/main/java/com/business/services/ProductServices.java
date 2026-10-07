package com.business.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.business.entities.Product;
import com.business.repositories.ProductRepository;

@Service
public class ProductServices {

	private final ProductRepository productRepository;

	public ProductServices(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// Add Product
	public void addProduct(Product p) {
		this.productRepository.save(p);
	}

	// Get all products
	public List<Product> getAllProducts() {
		return (List<Product>) this.productRepository.findAll();
	}

	// Get single product
	public Product getProduct(int id) {
		return this.productRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("No product found with id: " + id));
	}

	// Update product — load the managed row, mutate it, then save
	public void updateproduct(Product p, int id) {
		Product existing = getProduct(id);
		existing.setPname(p.getPname());
		existing.setPprice(p.getPprice());
		existing.setPdescription(p.getPdescription());
		this.productRepository.save(existing);
	}

	// Delete product
	public void deleteProduct(int id) {
		this.productRepository.deleteById(id);
	}

	// Get product by name (returns null when not found)
	public Product getProductByName(String name) {
		return this.productRepository.findByPname(name);
	}
}
