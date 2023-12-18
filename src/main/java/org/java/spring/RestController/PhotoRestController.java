package org.java.spring.RestController;

import java.util.List;

import org.java.spring.db.pojo.Photo;
import org.java.spring.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/photo")
public class PhotoRestController {

	@Autowired
	private PhotoService photoServ;
	
	@GetMapping
	public ResponseEntity<List<Photo>> getIndex(Model model,
			@RequestParam(name = "searchValue", required = false) String searchValue) {

		List<Photo> photos = searchValue == null ? photoServ.findAll() : photoServ.findByTitle(searchValue);

		model.addAttribute("searchValue", searchValue);
		model.addAttribute("photos", photos);

		return new ResponseEntity<>(photos, HttpStatus.OK);
	}
	
}
