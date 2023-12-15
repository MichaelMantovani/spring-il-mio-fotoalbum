package org.java.spring;

import java.util.List;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.pojo.Photo;
import org.java.spring.db.serv.CategoryService;
import org.java.spring.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		categoryService.save(new Category("Nature", "green"));
		categoryService.save(new Category("Travel", "blue"));
		categoryService.save(new Category("Food", "red"));
		
		List<Category> categories = categoryService.findAll();
		
		
		photoService.save(new Photo("Foto1", "Molto bella", "https://picsum.photos/seed/picsum/200/300", true,categories.get(0)));
		photoService.save(new Photo("Foto2", "Molto bella", "https://picsum.photos/seed/picsum/200/300", true, categories.get(1)));
		photoService.save(new Photo("Foto3", "Molto bella", "https://picsum.photos/seed/picsum/200/300", true, categories.get(2)));
		
		
		
	}

}
