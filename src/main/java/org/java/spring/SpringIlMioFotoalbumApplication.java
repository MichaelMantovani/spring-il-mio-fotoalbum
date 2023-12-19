package org.java.spring;

import java.util.List;

import org.java.spring.auth.db.conf.AuthConf;
import org.java.spring.auth.db.pojo.Role;
import org.java.spring.auth.db.pojo.User;
import org.java.spring.auth.db.serv.RoleService;
import org.java.spring.auth.db.serv.UserService;
import org.java.spring.db.pojo.Category;
import org.java.spring.db.pojo.Message;
import org.java.spring.db.pojo.Photo;
import org.java.spring.db.serv.CategoryService;
import org.java.spring.db.serv.MessageService;
import org.java.spring.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner {

	@Autowired
	private PhotoService photoService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	@Autowired 
	private MessageService messageService;

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Inizializzazione categorie
		categoryService.save(new Category("Nature", "green"));
		categoryService.save(new Category("Travel", "blue"));
		categoryService.save(new Category("Food", "red"));

		List<Category> categories = categoryService.findAll();

//		Inizializzazione foto
		photoService
				.save(new Photo("Foto1", "Molto bella", "https://picsum.photos/id/237/200", true, categories.get(0)));
		photoService
				.save(new Photo("Foto2", "Molto bella", "https://picsum.photos/id/230/200", true, categories.get(1)));
		photoService
				.save(new Photo("Foto3", "Molto bella", "https://picsum.photos/id/233/200", true, categories.get(2)));
		photoService
				.save(new Photo("Foto4", "Molto bella", "https://picsum.photos/id/234/200", true, categories.get(1)));
		photoService
				.save(new Photo("Foto5", "Molto bella", "https://picsum.photos/id/235/200", true, categories.get(2)));
		photoService
				.save(new Photo("Foto6", "Molto bella", "https://picsum.photos/id/236/200", true, categories.get(0)));
		photoService
				.save(new Photo("Foto7", "Molto bella", "https://picsum.photos/id/238/200", true, categories.get(1)));
		photoService
				.save(new Photo("Foto8", "Molto bella", "https://picsum.photos/id/239/200", true, categories.get(2)));
		photoService
				.save(new Photo("Foto9", "Molto bella", "https://picsum.photos/id/240/200", true, categories.get(1)));
		photoService
				.save(new Photo("Foto10", "Molto bella", "https://picsum.photos/id/241/200", true, categories.get(2)));

//		Inizializzazione ruolo admin
		Role roleAdmin = new Role("ADMIN");
		roleService.save(roleAdmin);

//		Crittografia della password
		String pws = AuthConf.passwordEncoder().encode("pws");

//		Inizializzazione utente admin
		User michAdmin = new User("MichAdmin", pws, roleAdmin);
		userService.save(michAdmin);
		
		Message message = new Message("Sono molto belle le tue foto", "fabio.rossi@gmail.com","Fabio", michAdmin);
		Message message1 = new Message("Mi piacerebbe discutere di una possibile collaborazione","Alice", "Alice", michAdmin);
		Message message2 = new Message("Complimenti per il tuo lavoro", "carlo.bianchi@yahoo.com","Carlo", michAdmin);
		Message message3 = new Message("Ho una domanda riguardo al tuo portfolio", "giulia.verdi@hotmail.com","Giulia", michAdmin);
		Message message4 = new Message("Ciao, vorrei richiedere un preventivo per un progettofgrgrgrhgrgiorjgjirgrijgiorjgorigiorjriojgorijriojgriojgroigjrgiojergioerjgioefhjvuiodefhviopdfuhvbdf8i9p7vyedfm90[cujr0[mavtuer0[8tvuer890[vgnmher9pgv78yerhn890[vberyugv98meryg0vbnm8e5gv89amegv98meryher98mvher8m9ervhvm89herv80m9rhva8m9h", "marco.rossi@gmail.com","Marco", michAdmin);
		messageService.save(message);
		messageService.save(message1);
		messageService.save(message2);
		messageService.save(message3);
		messageService.save(message4);


	}

}
