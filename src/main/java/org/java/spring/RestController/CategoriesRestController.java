package org.java.spring.RestController;

import java.util.List;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.serv.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/category")
public class CategoriesRestController {

	@Autowired
	private CategoryService categServ;

	@GetMapping
	public ResponseEntity<List<Category>> getCategoryIndex(Model model) {
		List<Category> categories = categServ.findAll();

		model.addAttribute(categories);

		return new ResponseEntity<>(categories, HttpStatus.OK);

	}
}
