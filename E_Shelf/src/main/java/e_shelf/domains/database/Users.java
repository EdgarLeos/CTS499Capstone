package e_shelf.domains.database;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	private int id_users;
	private String username;
	private String password;
	private String role;
	private String enabled;
	
	public Users() {}

	public Users(int id_users, String username, String password, String role, String enabled) {
		super();
		this.id_users = id_users;
		this.username = username;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}

	public int getId_users() {
		return id_users;
	}

	public void setId_users(int id_users) {
		this.id_users = id_users;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	
	

}
