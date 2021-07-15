package e_shelf.domains.info;

import java.util.HashSet;
import java.util.Set;
import e_shelf.domains.database.Class;
import e_shelf.domains.database.Teacher;

public class SchoolInfo {
	
	private int id_school;
	
	private String school_name;
	
	private Set<String> classes = new HashSet<>();
	
	private Set<String> teachers = new HashSet<>();
	
	public SchoolInfo() {}

	public SchoolInfo(int id_school, String school_name, Set<String> classes, Set<String> teachers) {
		super();
		this.id_school = id_school;
		this.school_name = school_name;
		this.classes = classes;
		this.teachers = teachers;
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
	}

	public Set<String> getClasses() {
		return classes;
	}

	public void setClasses(Set<String> classes) {
		this.classes = classes;
	}

	public Set<String> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<String> teachers) {
		this.teachers = teachers;
	}

}