package movie.app.project.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface MovieRepository extends CrudRepository<Movie,Long>{
	
	// tietokantakäsittelyn rajapinta
	List<Movie> findByName(String name);
	

}
