package movie.app.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



//@NoArgsConstructor //luo luokalle parametrittoman konstruktorin
//@AllArgsConstructor //luo luokalle kaikki attribuutit sisältävän konstruktorin
//@Data //luo attribuuteille getterit ja setterit.
@Entity
public class User {

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
		public User(Long id, String username, String passwordHass, String role) {
			super();
			this.id = id;
			this.username = username;
			this.passwordHass = passwordHass;
			this.role = role;
		}
		public User() {
			super();
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPasswordHass() {
			return passwordHass;
		}
		public void setPasswordHass(String passwordHass) {
			this.passwordHass = passwordHass;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", passwordHass=" + passwordHass + ", role=" + role
					+ "]";
		}

		
	}

