package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.pojo.Photo;
import org.java.spring.db.serv.CategoryService;
import org.java.spring.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService catServ;

	@Autowired
	private PhotoService photoServ;

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

	@GetMapping("/category/create")
	public String createCategory(Model model) {

		model.addAttribute("category", new Category());

		return "categoryForm";
	}

	@PostMapping("/category/create")
	public String storeCategory(Model model, @Valid @ModelAttribute Category category, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			model.addAttribute("cateogory", category);

			return "categoryForm";
		}

		catServ.save(category);

		return "redirect:/category";
	}

	@PostMapping("/category/{id}/delete")
	public String deleteCategory(@PathVariable int id) {

		Category category = catServ.findById(id);

		List<Photo> categoryPhoto = category.getPhotos();
		categoryPhoto.forEach(photo -> {

			photo.getCategories().remove(category);
			photoServ.save(photo);
		});

		catServ.delete(category);

		return "redirect:/category";
	}

}
