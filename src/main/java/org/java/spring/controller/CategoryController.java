package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.serv.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService catServ;
	
	@GetMapping("/category")
	public String getCategoriesIndex(Model model) {
		List<Category> categories = catServ.findAll();
		model.addAttribute("categories", categories);

		return "categIndex";
	}

	@GetMapping("/category/{id}")
	public String getCategoryDetail(Model model, @PathVariable int id) {
		model.addAttribute("category", catServ.findById(id));

		return "categDetail";
	}

}
