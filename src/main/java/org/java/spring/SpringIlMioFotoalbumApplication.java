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
		
		
		photoService.save(new Photo("Foto1", "Molto bella", "https://picsum.photos/id/237/200", true,categories.get(0)));
		photoService.save(new Photo("Foto2", "Molto bella", "https://picsum.photos/id/230/200", true, categories.get(1)));
		photoService.save(new Photo("Foto3", "Molto bella", "https://picsum.photos/id/233/200", true, categories.get(2)));
		photoService.save(new Photo("Foto4", "Molto bella", "https://picsum.photos/id/234/200", true, categories.get(1)));
		photoService.save(new Photo("Foto5", "Molto bella", "https://picsum.photos/id/235/200", true, categories.get(2)));
		photoService.save(new Photo("Foto6", "Molto bella", "https://picsum.photos/id/236/200", true, categories.get(0)));
		photoService.save(new Photo("Foto7", "Molto bella", "https://picsum.photos/id/238/200", true, categories.get(1)));
		photoService.save(new Photo("Foto8", "Molto bella", "https://picsum.photos/id/239/200", true, categories.get(2)));
		photoService.save(new Photo("Foto9", "Molto bella", "https://picsum.photos/id/240/200", true, categories.get(1)));
		photoService.save(new Photo("Foto10", "Molto bella", "https://picsum.photos/id/241/200", true, categories.get(2)));

		
		
		
		
	}

}
