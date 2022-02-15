package com.melissacheng.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.productscategories.models.Category;
import com.melissacheng.productscategories.models.Product;
import com.melissacheng.productscategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private ProductService productService;
	
	public List<Category> all() {
		return repository.findAll();
	}
	
	public Category create(Category item) {
		return repository.save(item);
	}
	
	public void delete(Long itemId) {
		repository.deleteById(itemId);
	}
	
	public Category retrieve(Long itemId) {
		Optional<Category> optionalCategory = repository.findById(itemId);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public Category save(Category item) {
		return repository.save(item);
	}
	
	public Category addProductToCategory(Long productId, Long categoryId) {
		
		Product thisProduct = productService.retrieve(productId);

		Category thisCategory = this.retrieve(categoryId);
		
		thisCategory.getProducts().add(thisProduct);
		
		return repository.save(thisCategory);
	}
	
	// Retrieves a list of all categories for a particular product
	public List<Category> getCategories(Long productId) {
		Product product = productService.retrieve(productId);
		return repository.findAllByProducts(product);
	}
	
	// Retrieves a list of any categories a particular product does not belong to
	public List<Category> getNotInCategories(Long productId) {
		Product product = productService.retrieve(productId);
		return repository.findByProductsNotContains(product);
	}
    
}
