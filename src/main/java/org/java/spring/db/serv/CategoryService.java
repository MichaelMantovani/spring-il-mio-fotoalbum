package org.java.spring.db.serv;

import java.util.List;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

	public Category findById(int id) {
		return categoryRepo.findById(id).get();
	}

	public List<Category> findByName(String name) {

		return categoryRepo.findByNameContainingIgnoreCase(name);
	}
	
	public void delete(Category category) {
		categoryRepo.delete(category);
	}

	public void save(Category category) {
		categoryRepo.save(category);
	}
}
