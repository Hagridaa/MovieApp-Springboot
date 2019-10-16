package movie.app.project.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


//tietokanta käsittelyn rajapinta
public interface CategoryRepository extends CrudRepository <Category, Long> {

	//jotta voidaan hakea nimellä
	List<Category> findByName(String name);
}
