package movie.app.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;




//@NoArgsConstructor //luo luokalle parametrittoman konstruktorin
//@AllArgsConstructor //luo luokalle kaikki attribuutit sisältävän konstruktorin
//@Data //luo attribuuteille getterit ja setterit.
@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "categoryId")
    private Category category;

	public Movie(Long id, String name, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public Movie() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", category=" + category + "]";
	}

	
}


