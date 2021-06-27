package e_shelf.domains.info;

import java.util.List;
import java.util.Set;

import e_shelf.domains.database.Resources;
import e_shelf.domains.database.Class;

public class TeacherInfo {
	
	private int id_teacher;
	private String last_name;
	private String firts_name;
	private String tittle;
	private String teacher_name;
	private String email;
	private String low_grade;
	private String high_grade;
	private List<Resources> resources;
	private String school_name;
	private Set<Class> classes;
	
	public TeacherInfo() {};
	
	public TeacherInfo(int id_teacher, String last_name, String firts_name, String tittle, String teacher_name,
			String email, String low_grade, String high_grade, List<Resources> resources, String school_name,
			Set<Class> classes) {
		super();
		this.id_teacher = id_teacher;
		this.last_name = last_name;
		this.firts_name = firts_name;
		this.tittle = tittle;
		this.teacher_name = teacher_name;
		this.email = email;
		this.low_grade = low_grade;
		this.high_grade = high_grade;
		this.resources = resources;
		this.school_name = school_name;
		this.classes = classes;
	}

	public int getId_teacher() {
		return id_teacher;
	}

	public void setId_teacher(int id_teacher) {
		this.id_teacher = id_teacher;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirts_name() {
		return firts_name;
	}

	public void setFirts_name(String firts_name) {
		this.firts_name = firts_name;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLow_grade() {
		return low_grade;
	}

	public void setLow_grade(String low_grade) {
		this.low_grade = low_grade;
	}

	public String getHigh_grade() {
		return high_grade;
	}

	public void setHigh_grade(String high_grade) {
		this.high_grade = high_grade;
	}

	public List<Resources> getResources() {
		return resources;
	}

	public void setResources(List<Resources> resources) {
		this.resources = resources;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public Set<Class> getClasses() {
		return classes;
	}

	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classes == null) ? 0 : classes.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firts_name == null) ? 0 : firts_name.hashCode());
		result = prime * result + ((high_grade == null) ? 0 : high_grade.hashCode());
		result = prime * result + id_teacher;
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((low_grade == null) ? 0 : low_grade.hashCode());
		result = prime * result + ((resources == null) ? 0 : resources.hashCode());
		result = prime * result + ((school_name == null) ? 0 : school_name.hashCode());
		result = prime * result + ((teacher_name == null) ? 0 : teacher_name.hashCode());
		result = prime * result + ((tittle == null) ? 0 : tittle.hashCode());
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
		TeacherInfo other = (TeacherInfo) obj;
		if (classes == null) {
			if (other.classes != null)
				return false;
		} else if (!classes.equals(other.classes))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firts_name == null) {
			if (other.firts_name != null)
				return false;
		} else if (!firts_name.equals(other.firts_name))
			return false;
		if (high_grade == null) {
			if (other.high_grade != null)
				return false;
		} else if (!high_grade.equals(other.high_grade))
			return false;
		if (id_teacher != other.id_teacher)
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (low_grade == null) {
			if (other.low_grade != null)
				return false;
		} else if (!low_grade.equals(other.low_grade))
			return false;
		if (resources == null) {
			if (other.resources != null)
				return false;
		} else if (!resources.equals(other.resources))
			return false;
		if (school_name == null) {
			if (other.school_name != null)
				return false;
		} else if (!school_name.equals(other.school_name))
			return false;
		if (teacher_name == null) {
			if (other.teacher_name != null)
				return false;
		} else if (!teacher_name.equals(other.teacher_name))
			return false;
		if (tittle == null) {
			if (other.tittle != null)
				return false;
		} else if (!tittle.equals(other.tittle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TeacherInfo [id_teacher=" + id_teacher + ", last_name=" + last_name + ", firts_name=" + firts_name
				+ ", tittle=" + tittle + ", teacher_name=" + teacher_name + ", email=" + email + ", low_grade="
				+ low_grade + ", high_grade=" + high_grade + ", resources=" + resources + ", school_name=" + school_name
				+ ", classes=" + classes + "]";
	}
	
	

}
