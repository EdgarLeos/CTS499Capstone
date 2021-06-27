package e_shelf.domains.database;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

//Teacher object to link to dB with its proper constructors, getters and setters. 
@Entity
@Table(name = "school")
public class School {
	
	@Id
	private int id_school;
	private String school_name;
	
	public School() {}

	public School(int id_school, String school_name) {
		super();
		this.id_school = id_school;
		this.school_name = school_name;
	}

	public int getId_school() {
		return id_school;
	}

	public void setId_school(int id_school) {
		this.id_school = id_school;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	};
	
	
	

}
