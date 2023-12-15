package org.java.spring.db.serv;

import java.util.List;

import org.java.spring.db.pojo.Photo;
import org.java.spring.db.repo.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

	@Autowired
	private PhotoRepository photoRepo;

	public List<Photo> findAll() {
		return photoRepo.findAll();
	}

	public Photo findById(int id) {
		return photoRepo.findById(id).get();
	}

	public List<Photo> findByTitle(String title) {

		return photoRepo.findByTitleContainingIgnoreCase(title);
	}
	
	public void delete(Photo photo) {
		photoRepo.delete(photo);
	}

	public void save(Photo photo) {
		photoRepo.save(photo);
	}
}
