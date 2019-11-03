package movie.app.project.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;




//@NoArgsConstructor //luo luokalle parametrittoman konstruktorin
//@AllArgsConstructor //luo luokalle kaikki attribuutit sisältävän konstruktorin
//@Data //luo attribuuteille getterit ja setterit.
@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "movies name is mandatory")
	@NotNull
	@Size(min=1, max=30)
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
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


