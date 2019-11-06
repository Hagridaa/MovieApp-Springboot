package Movie.app.project;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import movie.app.project.domain.Category;
import movie.app.project.domain.Movie;
import movie.app.project.domain.MovieRepository;

//annotation tells JUnit to run using Spring’s testing support
@RunWith(SpringRunner.class)
@DataJpaTest 
//annotation will configure in-memory database, JPA and Spring
//Data. It also turns on SQL logging
public class MovieRepositoryTest {
	
	//This annotation allows Spring to resolve
	//and inject collaborating beans into your bean.
	@Autowired
	private MovieRepository mrepository;
	
	
	
	  @Test
	    public void findByName() {
		  Optional<Movie> movies = mrepository.findByName("Joker");
	        assertThat(movies.get().getName()).isEqualTo("Joker");
	        
	  }
	        
	//annotation defines a method to be test method
	@Test
	public void createNewStudent() {
		
		Movie movie = new Movie(null, "Joker", new Category("Drama"));
		mrepository.save(movie);
		assertThat(movie.getCategory()).isNotNull();
		assertThat(movie.getName()).startsWith("J").endsWith("r");
	}
	
	 
	
}