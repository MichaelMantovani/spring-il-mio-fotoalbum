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
	public String getPhotoDetail(Model model, @PathVariable int id) {
		model.addAttribute("photo", photoServ.findById(id));

		return "photoDetail";
	}

	@GetMapping("/photo/create")
	public String createNewPhoto(Model model) {
		model.addAttribute("photo", new Photo());
		List<Category> categories = catServ.findAll();
		model.addAttribute("categories", categories);
		return "photoForm";
	}

	@PostMapping("/photo/create")
	public String storeNewPhoto(Model model, @Valid @ModelAttribute Photo photo, BindingResult bindingResult) {

		System.out.println("Photo:\n" + photo);

		if (bindingResult.hasErrors()) {

			System.out.println(bindingResult);
			model.addAttribute("photo", photo);
			return "photoForm";
		}

		try {
			photoServ.save(photo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "redirect:/";
	}
	
	@GetMapping("photo/edit/{id}")
	public String editPhoto(Model model, @PathVariable int id) {
		
		Photo photo = photoServ.findById(id);
		model.addAttribute("photo", photo);
		
		return "photoForm";
	}
	@PostMapping("photo/edit/{id}")
	public String updaetPhoto(Model model, @Valid @ModelAttribute Photo photo, BindingResult bindingResult) {


		if (bindingResult.hasErrors()) {

			System.out.println(bindingResult);
			model.addAttribute("photo", photo);
			return "pizzaForm";
		}

		try {
			photoServ.save(photo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "redirect:/";
	}
	
	@PostMapping("/photo/{id}/delete")
	public String deletePhoto(@PathVariable int id) {
		Photo photo = photoServ.findById(id);
		
		photoServ.delete(photo);
		
		return "redirect:/";
	}
	

}
