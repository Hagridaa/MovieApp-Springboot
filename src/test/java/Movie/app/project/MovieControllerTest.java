package Movie.app.project;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import movie.app.project.web.MovieController;

//Testing that the context is creating controller

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieControllerTest {
	
	@Autowired
	private MovieController mcontroller;
	
	@Test
	public void contexLoads() throws Exception {
		
		assertThat(mcontroller).isNotNull();
	}

}
