package movie.app.project.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import movie.app.project.domain.Answer;
import movie.app.project.domain.AnswerRepository;
import movie.app.project.domain.CategoryRepository;
import movie.app.project.domain.Movie;
import movie.app.project.domain.MovieRepository;


@Controller
public class MovieController {
	
	// Spring-alusta luo sovelluksen käynnistyessä MovieRepository-rajapintaa toteuttavan luokan olion 
	   // ja kytkee olion MovieController-luokasta luodun olion attribuuttiolioksi
	@Autowired
	MovieRepository movieRepository;
	
	@RequestMapping(value="/login")
    public String index() {	
        return "login";
    }
	
	@Autowired
	CategoryRepository categoryRepository;
	private static final Logger log = LoggerFactory.getLogger(MovieController.class);
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String getMoviesNow(Model model) {
		List<Movie> movies = (List<Movie>) movieRepository.findAll();//haeta tietokannasta elokuvat
		//välitä modelin avulla elokuvalista templatelle nähtävästi
		model.addAttribute("movies", movies);// välitetään lista templatelle model-olion avulla
		System.out.println("tietokannasta elokuvat ovat" + movies);
		return "index";
		// DispatherServlet saa tämän template-nimen ja kutsuu seuraavaksi booklist.html-template
		// joka prosessoidaan palvelimella
		}
	
	
	
	// tyhjän lomakkeen muodostaminen
	@RequestMapping (value = "/addmovie", method = RequestMethod.GET)
	public String getNewMovieForm(Model model) {
		model.addAttribute("movie", new Movie()); //luodaan tyhjä movie- olio
		model.addAttribute("categories", categoryRepository.findAll());
		return "addmovie";
	}
	
	//lomakkeen tietojen vastaanotto ja tallennus kantaa (H2)
	
	@RequestMapping(value = "/addmovie", method = RequestMethod.POST)
	public String add(@Valid Movie movie, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("movie",movie);
			model.addAttribute("categories", categoryRepository.findAll());
			return "addmovie";
		}
			movieRepository.save(movie);
			return ("redirect:movielist");
	}
	
	
	//listaaminen
	@RequestMapping(value = "/movielist" , method = RequestMethod.GET)
	public String getMovies(Model model) {
		List<Movie> movies = (List<Movie>) movieRepository.findAll();//haeta tietokannasta elokuvat
		//välitä modelin avulla elokuvalista templatelle nähtävästi
		model.addAttribute("movies", movies);// välitetään lista templatelle model-olion avulla
		System.out.println("tietokannasta elokuvat ovat" + movies);
		return "movielist";
		// DispatherServlet saa tämän template-nimen ja kutsuu seuraavaksi movielist.html-template
		// joka prosessoidaan palvelimella
}
	
	//delete
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteMovie(@PathVariable("id") Long movieId, Model model) {
		movieRepository.deleteById(movieId);
		return "redirect:../movielist";
	}
	
	//tietojen muokkaaminen
	//haetaan annettu id kuten delete toiminnossa getillä
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editMovie(@PathVariable("id") Long movieId, Model model) {
		//etsitään id:n avulla muokattavan movien tiedot
		//Optional vaihtoehdolla voi tehdä niin, että jos tietoa ei löydykkään niin sovellus ei kaadu
		Optional<Movie> foundedMovie = movieRepository.findById(movieId);
		model.addAttribute("foundedmovie", foundedMovie); //// välitetään lista templatelle model-olion avulla
		model.addAttribute("categories", categoryRepository.findAll());
		return "edit";
	}
	//Päivitys, haetaan kannasta tiedot ja takaisin update komennolla ei inserttinä ette itee uutta
	//Lomakkeen tietojen vastaanotto ja tallennus kantaan
	@RequestMapping(value = "/editmovie",method = RequestMethod.POST)
	public String update(Movie movie) {
		log.info("Tallennetaan elokuva: " + movie.toString());
		if
		(movieRepository.existsById(movie.getId())) {
			log.info("Tallennetaan elokuva: " + movie.toString());
				movieRepository.save(movie);
		}
					return "redirect:../movielist";
}
	
	//search by name
	@RequestMapping(value = "/searchmovie", method = RequestMethod.POST)
	public String searchByName(@RequestParam (value = "name") String name, Model model) {
		log.info("Haettava elokuva: " + name);
		Optional<Movie> foundedMovie = movieRepository.findByName(name);
		log.info("Löydetty elokuva: " + foundedMovie.toString());
		model.addAttribute("foundedmovie", foundedMovie.get().getName());
	    return "movielist";
	}
	
	@Autowired
	AnswerRepository answerRepository;
	
	//palautteen anto, answer
	// tyhjän lomakkeen muodostaminen
	@RequestMapping (value = "/feedback", method = RequestMethod.GET)
	public String getNewFeedbackForm(Model model) {
		model.addAttribute("answer", new Answer()); //luodaan tyhjä vastaus- olio
		return "feedback";
	}
	
	//palautteen tietojen vastaanotto ja tallennus kantaa (H2)
	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	public String add(Answer answer, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("answer",answer);
			return "feedback";
		}
			answerRepository.save(answer);
			return ("redirect:feedbacklist");
	}
	
	//vastausten listaaminen
		@RequestMapping(value = "/feedbacklist" , method = RequestMethod.GET)
		public String getAnswers(Model model) {
			List<Answer> answers = (List<Answer>) answerRepository.findAll();//haeta tietokannasta vastaukset
			//välitä modelin avulla elokuvalista templatelle nähtävästi
			model.addAttribute("answers", answers);// välitetään lista templatelle model-olion avulla
			System.out.println("tietokannasta vastaukset ovat" + answers);
			return "feedbacklist";
}
}


