package e_shelf.domains.info;

import java.util.List;

public class ClassesInfo {
	
	private int id_class;
	private String class_name;
	private String school;
	private List<String> teachers;
	
	public ClassesInfo() {}

	public ClassesInfo(int id_class, String class_name, String school, List<String> teachers) {
		super();
		this.id_class = id_class;
		this.class_name = class_name;
		this.school = school;
		this.teachers = teachers;
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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public List<String> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<String> teachers) {
		this.teachers = teachers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((class_name == null) ? 0 : class_name.hashCode());
		result = prime * result + id_class;
		result = prime * result + ((school == null) ? 0 : school.hashCode());
		result = prime * result + ((teachers == null) ? 0 : teachers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassesInfo other = (ClassesInfo) obj;
		if (class_name == null) {
			if (other.class_name != null)
				return false;
		} else if (!class_name.equals(other.class_name))
			return false;
		if (id_class != other.id_class)
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		if (teachers == null) {
			if (other.teachers != null)
				return false;
		} else if (!teachers.equals(other.teachers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassesInfo [id_class=" + id_class + ", class_name=" + class_name + ", school=" + school + ", teachers="
				+ teachers + "]";
	}
	
	
	

}
