package com.melissacheng.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.productscategories.models.Category;
import com.melissacheng.productscategories.models.Product;
import com.melissacheng.productscategories.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> all() {
		return repository.findAll();
	}
	
	public Product create(Product item) {
		return repository.save(item);
	}
	
	public void delete(Long itemId) {
		repository.deleteById(itemId);
	}
	
	public Product retrieve(Long itemId) {
		Optional<Product> optionalProduct = repository.findById(itemId);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	public Product save(Product item) {
		return repository.save(item);
	}
	
// Retrieves a list of all categories for a particular product
	public List<Product> getProducts(Category item) {
		return repository.findAllByCategories(item);
	}
	
	// Retrieves a list of any categories a particular product does not belong to
	public List<Product> getNotInCategories(Category item) {
		return repository.findByCategoriesNotContains(item);
	}
}
