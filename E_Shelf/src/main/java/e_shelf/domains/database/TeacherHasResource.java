package e_shelf.domains.database;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "teacher_has_resources")
public class TeacherHasResource implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_teacher_has_resources;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id_teacher", referencedColumnName = "id_teacher")
	private Teacher teacher;
	
	@ManyToOne
	@JoinColumn(name = "resources_id_resources", referencedColumnName = "id_resources")
	private Resources resources;
	
	@JoinColumn(name = "teacher_username")
	private String teacher_username;
	
	@JoinColumn(name = "teacher_passwored")
	private String teacher_password;

	public TeacherHasResource() {};
	
	
	
	
	public TeacherHasResource(Teacher teacher, Resources resources, String teacher_username, String teacher_password) {
		super();
		this.teacher = teacher;
		this.resources = resources;
		this.teacher_username = teacher_username;
		this.teacher_password = teacher_password;
	}




	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Resources getResources() {
		return resources;
	}

	public void setResources(Resources resources) {
		this.resources = resources;
	}

	public String getTeacher_username() {
		return teacher_username;
	}

	public void setTeacher_username(String teacher_username) {
		this.teacher_username = teacher_username;
	}

	public String getTeacher_password() {
		return teacher_password;
	}

	public void setTeacher_password(String teacher_password) {
		this.teacher_password = teacher_password;
	}
	
	

}
