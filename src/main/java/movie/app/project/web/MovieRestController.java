package movie.app.project.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import movie.app.project.domain.CategoryRepository;
import movie.app.project.domain.Movie;
import movie.app.project.domain.MovieRepository;

@RestController
public class MovieRestController {
	
			// Spring-alusta luo sovelluksen käynnistyessä MovieRepository-rajapintaa toteuttavan luokan olion 
		   // ja kytkee olion MovieController-luokasta luodun olion attribuuttiolioksi
		@Autowired
		MovieRepository movieRepository;
		
		@Autowired
		CategoryRepository categoryRepository;
		private static final Logger log = LoggerFactory.getLogger(MovieController.class);
		
		//REST service that return all movies (JSON)
		
		@RequestMapping(value="/api/movielist",method = RequestMethod.GET)
		public Iterable<Movie> movielistRest() {
			return movieRepository.findAll();
			
		}
		
		//REST service that return one book by id (JSON)
		//path variable to get book id
		@RequestMapping(value="/api/movie/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Movie> findBookRest(@PathVariable("id") Long movieId) {
		return movieRepository.findById(movieId);
		}
			
	}


