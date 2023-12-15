package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.pojo.Photo;
import org.java.spring.db.serv.CategoryService;
import org.java.spring.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PhotoController {
	
	@Autowired
	private PhotoService photoServ;
	
	@Autowired
	private CategoryService catServ;
	

	
	@GetMapping()
	public String getPhotosIndex(Model model) {
		List<Photo> photos = photoServ.findAll();
		model.addAttribute("photos", photos);
		
		return "photoIndex";
	}
	
	@GetMapping("/photo/{id}")
	public String getPhotoDetail(Model model,@PathVariable int id) {
		model.addAttribute("photo", photoServ.findById(id));
		
		return "photoDetail";
	}
	
	@GetMapping("/photo/create")
	public String createNewPhoto(Model model) {
		model.addAttribute("photo",new Photo());
		List<Category> categories = catServ.findAll();
		model.addAttribute("categories", categories);
		return "photoForm";
	}
	
	
	
}
