package com.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.business.entities.Product;
import com.business.repositories.ProductRepository;
@Component
public class ProductServices 
{
	@Autowired
	private ProductRepository productRepository;

	//add Product
	public void addProduct(Product p)
	{
		this.productRepository.save(p);
	}


	//getAll products
	public List<Product> getAllProducts()
	{
		List<Product> products=(List<Product>)this.productRepository.findAll();
		return products;
	}

	//get Single Product
	public Product getProduct(int id)
	{
		Optional<Product> optional = this.productRepository.findById(id);
		Product product=optional.get();
		return product;
	}

	//update Product
	public void updateproduct(Product p,int id)
	{
		p.setPid(id);
		Optional<Product> optional = this.productRepository.findById(id);
		Product prod=optional.get();

		if(prod.getPid()==id)
		{
			this.productRepository.save(p);				
		}
	}
	//delete product
	public void deleteProduct(int id)
	{
		this.productRepository.deleteById(id);
	}

	//Get Product By Name
	public Product getProductByName(String name)
	{
		
		Product product= this.productRepository.findByPname(name);
		if(product!=null)
		{
			return product;
		}
		return null;
	
	}
}