package com.melissacheng.productscategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.melissacheng.productscategories.models.Category;
import com.melissacheng.productscategories.models.Product;
import com.melissacheng.productscategories.services.CategoryService;
import com.melissacheng.productscategories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping("/new")
	public String newProductForm(
			@ModelAttribute("product") Product product) {
		return "addProduct.jsp";
	}
	
	@PostMapping("/add")
	public String addProduct(
			@Valid @ModelAttribute("product") Product product,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			return "addProduct.jsp";
		} else {
			service.create(product);
			redirectAttributes.addFlashAttribute("message", "Product has been added");
		}
		
		return "redirect:/products/new";
	}
	
	@GetMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", service.all());
		return "allProducts.jsp";
	}
	
	@GetMapping("/{id}")
	public String showProduct(
			@PathVariable Long id,
			Model model,
			@ModelAttribute("product") Product product,
			@ModelAttribute("category") Category category) {
		
		model.addAttribute("categories", categoryService.all());
		model.addAttribute("product", service.retrieve(id));
		
		model.addAttribute("categoriesForProduct", categoryService.getCategories(id));
		model.addAttribute("remainingCategories", categoryService.getNotInCategories(id));
		
		System.out.println(categoryService.getNotInCategories(id));
		
		return "showProduct.jsp";
	}
	
	@PostMapping("/{id}")
	public String addCategory(
			@PathVariable Long id,
			@ModelAttribute("category") Category category) {
		
		Long categoryId = category.getId();
		
		categoryService.addProductToCategory(id, categoryId);
		
		return String.format("redirect:/products/%d", id); 
	}
	

}
