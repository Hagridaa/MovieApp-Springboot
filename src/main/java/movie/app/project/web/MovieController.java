package movie.app.project.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import movie.app.project.domain.CategoryRepository;
import movie.app.project.domain.Movie;
import movie.app.project.domain.MovieRepository;


@Controller
public class MovieController {
	
	// Spring-alusta luo sovelluksen käynnistyessä MovieRepository-rajapintaa toteuttavan luokan olion 
	   // ja kytkee olion MovieController-luokasta luodun olion attribuuttiolioksi
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	private static final Logger log = LoggerFactory.getLogger(MovieController.class);
	
	
	
	// tyhjän kirjalomakkeen muodostaminen
	@RequestMapping (value = "/addmovie", method = RequestMethod.GET)
	public String getNewMovieForm(Model model) {
		model.addAttribute("movie", new Movie()); //luodaan tyhjä movie- olio
		model.addAttribute("categories", categoryRepository.findAll());
		return "addmovie";
	}
	
	//lomakkeen tietojen vastaanotto ja tallennus kantaa (H2)
	@RequestMapping(value = "/addmovie", method = RequestMethod.POST)
	public String add(Movie movie) {
		movieRepository.save(movie);
		return "redirect:movielist";
	}
	
	
	//listaaminen
	@RequestMapping(value = "/movielist" , method = RequestMethod.GET)
	public String getMovies(Model model) {
		List<Movie> movies = (List<Movie>) movieRepository.findAll();
		return "movielist";
}
	
	//delete
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteMovie(@PathVariable("id") Long movieId, Model model) {
		movieRepository.deleteById(movieId);
		return "redirect:../movielist";
	}
	
	//tietojen muokkaaminen
}


