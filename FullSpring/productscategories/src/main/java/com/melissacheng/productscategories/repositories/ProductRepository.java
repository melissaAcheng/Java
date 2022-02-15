package com.melissacheng.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melissacheng.productscategories.models.Category;
import com.melissacheng.productscategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findAll();

	// Retreives a list of all products for a particular category
	List<Product> findAllByCategories(Category category);
	
	// Retrieves a list of any products that is not assigned to a particular category
	List<Product> findByCategoriesNotContains(Category category);
	
}
