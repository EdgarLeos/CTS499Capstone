package e_shelf.domains.database;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

//Teacher object to link to dB with its proper constructors, getters and setters. 
@Entity
@Table(name = "class")
public class Class {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_class;
	
	private String class_name;
	
	@ManyToOne
	@JoinColumn(name = "school_id_school", referencedColumnName = "id_school")
	private School school;
	
	@ManyToMany(mappedBy = "class_has_teacher")
	Set<Teacher>class_has_teacher;
	
	public Class() {}

	public Class(int id_class, String class_name, School school, Set<Teacher> class_has_teacher) {
		super();
		this.id_class = id_class;
		this.class_name = class_name;
		this.school = school;
		this.class_has_teacher = class_has_teacher;
	}

	public int getId_class() {
		return id_class;
	}

	public void setId_class(int id_class) {
		this.id_class = id_class;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Set<Teacher> getClass_has_teacher() {
		return class_has_teacher;
	}

	public void setClass_has_teacher(Set<Teacher> class_has_teacher) {
		this.class_has_teacher = class_has_teacher;
	};
	
	
	

}
