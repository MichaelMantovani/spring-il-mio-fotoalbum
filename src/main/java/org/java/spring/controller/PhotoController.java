package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Photo;
import org.java.spring.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhotoController {
	
	@Autowired
	private PhotoService photoServ;
	

	
	@GetMapping()
	public String getPhotoIndex(Model model) {
		List<Photo> photos = photoServ.findAll();
		model.addAttribute("photos", photos);
		
		return "photoIndex";
		
	}
	
}
