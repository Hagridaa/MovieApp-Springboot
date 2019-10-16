package movie.app.project.domain;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {
	User findByUsername(String username);
	//Metodi= kysely, Nyt voidaan etsiä tietokannasta usernamella käyttäjiä
}
