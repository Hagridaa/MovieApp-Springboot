package movie.app.project.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


//Lombok

//@NoArgsConstructor //luo luokalle parametrittoman konstruktorin
//@AllArgsConstructor //luo luokalle kaikki attribuutit sisältävän konstruktorin
//@Data //luo attribuuteille getterit ja setterit.
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Movie> movies;
	
	public Category(String name) {
		this.name = name;
		
	}

	public Category() {
		
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name +"]";
	}
	
	
}
