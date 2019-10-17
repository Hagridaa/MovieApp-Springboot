package Movie.app.project;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import movie.app.project.domain.Category;
import movie.app.project.domain.Movie;
import movie.app.project.domain.MovieRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationTests {

	@Autowired
	private MovieRepository repository;
	
	@Test
	public void createNewMovie() {
		Movie movie = new Movie("Joker", new Category("Drama"));
		//repository.save(movie);
		//assertThat(movie.getId()).isNotNull();

}
}
