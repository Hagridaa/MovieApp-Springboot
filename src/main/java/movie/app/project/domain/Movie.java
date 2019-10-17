package movie.app.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor //luo luokalle parametrittoman konstruktorin
@AllArgsConstructor //luo luokalle kaikki attribuutit sisältävän konstruktorin
@Data //luo attribuuteille getterit ja setterit.
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
	
//	public Movie(String name, Category category) {
//		this.name = name;
//		this.category = category;
//	}

	
}


