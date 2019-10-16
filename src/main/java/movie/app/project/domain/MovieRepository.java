package movie.app.project.domain;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie,Long>{
	
	// tietokantakäsittelyn rajapinta
	

}
