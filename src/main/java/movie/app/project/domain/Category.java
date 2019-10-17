package movie.app.project.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Lombok
@Entity
@NoArgsConstructor //luo luokalle parametrittoman konstruktorin
@AllArgsConstructor //luo luokalle kaikki attribuutit sisältävän konstruktorin
@Data //luo attribuuteille getterit ja setterit.
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
}
