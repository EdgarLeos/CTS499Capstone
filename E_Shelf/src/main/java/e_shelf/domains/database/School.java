package e_shelf.domains.database;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Teacher object to link to dB with its proper constructors, getters and setters. 
@Entity
@Table(name = "school")
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_school;
	private String school_name;
	
	@OneToMany(
	        mappedBy = "school",
	        fetch = FetchType.LAZY,
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	)
	private Set<Class> classes = new HashSet<>();
	
	
	
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
