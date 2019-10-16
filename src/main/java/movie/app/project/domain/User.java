package movie.app.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //luo luokalle parametrittoman konstruktorin
@AllArgsConstructor //luo luokalle kaikki attribuutit sisältävän konstruktorin
@Data //luo attribuuteille getterit ja setterit.
@Entity
public class User {
	//entity for application endusers
	//Attributes: username (unique), password,role
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id",nullable = false, updatable = false)
		private Long id;
		//nullable = pakollinen
		
		@Column(name = "username",nullable = false, unique = true)
		private String username;
		
		@Column(name = "password",nullable = false, unique = true)
		private String passwordHass;
		//koska salasana kryptataan
		
		@Column(name = "role", nullable = false)
		private String role;

	}

