package Movie.app.project;

	import static org.assertj.core.api.Assertions.assertThat;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.test.context.junit4.SpringRunner;

import movie.app.project.domain.User;
	
	

	@RunWith(SpringRunner.class)
	@SpringBootTest
	//annotation to use for regular
	//tests, as well as some specialized variants for testing parts of your application
	public class UserTest {

		@Test
		public void createNewUser() {
			//User user1 = new User(null, "user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user3 = new User(null, "user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			System.out.println("tulosta testi user3: " + user3.toString());
			assertThat(user3.getUsername().isEmpty());

	}
	}

