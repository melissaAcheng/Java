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
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/new")
	public String newCategoryForm(
			@ModelAttribute("category") Category category) {
		return "addCategory.jsp";
	}
	
	@PostMapping("/add")
	public String addCategory(
			@Valid @ModelAttribute("category") Category category,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			return "addCategory.jsp";
		} else {
			service.create(category);
			redirectAttributes.addFlashAttribute("message", "Category has been added");
		}
		
		return "redirect:/categories/new";
	}
	
	@GetMapping("/all")
	public String allCategories(Model model) {
		model.addAttribute("categories", service.all());
		return "allCategories.jsp";
	}
	
	@GetMapping("/{id}")
	public String showProduct(
			@PathVariable Long id,
			Model model,
			@ModelAttribute("product") Product product) { 	
		
		Category category = service.retrieve(id);
		
		model.addAttribute("category", service.retrieve(id));
		model.addAttribute("productsInCategory", productService.getProducts(category));
		model.addAttribute("remainingProducts", productService.getNotInCategories(category));
	
		
		return "showCategory.jsp";
	}
	
	@PostMapping("/{id}")
	public String addCategory(
			@PathVariable Long id,
			@ModelAttribute("product") Product product) {
		
		
		Long productId = product.getId();
		
		service.addProductToCategory(productId, id);
		
		return String.format("redirect:/categories/%d", id); 
	}
	
	
}
