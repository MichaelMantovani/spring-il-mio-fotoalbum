package org.java.spring.RestController;

import java.util.List;

import org.java.spring.db.pojo.Photo;
import org.java.spring.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("{id}")
	public ResponseEntity<Photo> getPhoto(@PathVariable int id) {

		Photo photo = photoServ.findById(id);

		if (photo == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Photo>(photo, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Photo> createNewPhoto(@RequestBody Photo photo) {
		photoServ.save(photo);

		return new ResponseEntity<>(photo, HttpStatus.OK);
	}
	
	@PutMapping("{id}/edit")
	public ResponseEntity<Photo> editPhoto(@PathVariable int id, @RequestBody Photo newPhoto) {
		Photo photo = photoServ.findById(id);
		photo.setTitle(newPhoto.getTitle());
		photo.setDescription(newPhoto.getDescription());
		photo.setUrl(newPhoto.getUrl());
		photo.setVisible(newPhoto.isVisible());
		
		photoServ.save(photo);
		
		return new ResponseEntity<Photo>(photo,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}/delete")
	public ResponseEntity<Photo> deletePhoto(@PathVariable int id){
		Photo photo = photoServ.findById(id);

		photoServ.delete(photo);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
