package movie.app.project;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import movie.app.project.domain.Category;
import movie.app.project.domain.CategoryRepository;
import movie.app.project.domain.Movie;
import movie.app.project.domain.MovieRepository;
import movie.app.project.domain.User;
import movie.app.project.domain.UserRepository;


@SpringBootApplication
public class ProjectApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectApplication.class);  //uusi loggeriattribuutti

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	//  testidatan luonti H2-testitietokantaan aina sovelluksen käynnistyessä
	@Bean
	public CommandLineRunner Demo(MovieRepository movieRepository, CategoryRepository categoryRepository, UserRepository urepository) { 
		return (args) -> {
			log.info("save a couple of movies");
			//(Long id, String title, String author, Integer year, String isbn, double price)
			
			categoryRepository.save(new Category("Scifi"));
			categoryRepository.save(new Category("Fantasy"));
			categoryRepository.save(new Category("Romance"));
			
			//drepository.findByName("Business").get(0)));
			movieRepository.save(new Movie("Joker", categoryRepository.findByName("Fantasy").get(0)));
			movieRepository.save(new Movie("Harry Potter", categoryRepository.findByName("Fantasy").get(0)));	
			
			// Create users: admin/admin user/user
			//(String username, String passwordHass, String email, String role)
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all movies");
			for (Movie movie : movieRepository.findAll()) {
				log.info(movie.toString());
			}
};
	}
	
}

	