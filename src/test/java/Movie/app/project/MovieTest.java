package Movie.app.project;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import movie.app.project.domain.Category;
import movie.app.project.domain.Movie;

@RunWith(SpringRunner.class)
@SpringBootTest
//annotation to use for regular
//tests, as well as some specialized variants for testing parts of your application
public class MovieTest {

	@Test
	public void createNewMovie() {
		Movie movie = new Movie(null, "Joker", new Category("Drama"));
		System.out.println("tulosta testi elokuva: " + movie.toString());
		assertThat(movie.getName()).isEqualTo("Joker");

}
}
