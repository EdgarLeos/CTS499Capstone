package e_shelf.domains.database;

import java.io.Serializable;

public class TeacherResourceId implements Serializable{
	
	private int teacher;
	private int resources;
	public int getTeacher() {
		return teacher;
	}
	public void setTeacher(int teacher) {
	this.teacher = teacher;
	}
	public int getResources() {
		return resources;
	}
	public void setResources(int resources) {
		this.resources = resources;
	}
	
	

}
