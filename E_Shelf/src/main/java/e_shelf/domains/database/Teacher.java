package e_shelf.domains.database;

import java.util.List;
import java.util.Set;
import javax.persistence.*;

//Teacher object to link to dB with its proper constructors, getters and setters. 
@Entity
@Table(name = "teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_teacher;
	private String last_name;
	private String first_name;
	private String title;
	private String teacher_name;
	private String email;
	private String low_grade;
	private String high_grade;
	
	@ManyToOne
	@JoinColumn(name= "school_id_school", referencedColumnName = "id_school")
	private School school; 
	
	@ManyToMany
	@JoinTable( name = "class_has_teacher", joinColumns = @JoinColumn(name = "teacher_id_teacher"), inverseJoinColumns = @JoinColumn(name = "class_id_class"))
	Set<Class>class_has_teacher;
	
	@OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	private List<TeacherHasResource> teacherHasResource;
	
	public Teacher() {}

	public Teacher(int id_teacher, String last_name, String first_name, String title, String teacher_name, String email,
			String low_grade, String high_grade, School school, Set<Class> class_has_teacher,
			List<TeacherHasResource> teacherHasResource) {
		super();
		this.id_teacher = id_teacher;
		this.last_name = last_name;
		this.first_name = first_name;
		this.title = title;
		this.teacher_name = teacher_name;
		this.email = email;
		this.low_grade = low_grade;
		this.high_grade = high_grade;
		this.school = school;
		this.class_has_teacher = class_has_teacher;
		this.teacherHasResource = teacherHasResource;
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Set<Class> getClass_has_teacher() {
		return class_has_teacher;
	}

	public void setClass_has_teacher(Set<Class> class_has_teacher) {
		this.class_has_teacher = class_has_teacher;
	}

	public List<TeacherHasResource> getTeacherHasResource() {
		return teacherHasResource;
	}

	public void setTeacherHasResource(List<TeacherHasResource> teacherHasResource) {
		this.teacherHasResource = teacherHasResource;
	};
	
	


	
}
