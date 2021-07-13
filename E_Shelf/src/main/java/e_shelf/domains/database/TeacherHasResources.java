package e_shelf.domains.database;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "teacher_has_resources")
public class TeacherHasResources{
	
	@Id
	@Column(name = "id_teacher_has_resources")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_teacher_has_resource;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id_teacher")
	private Teacher teacher;
	
	@ManyToOne
	@JoinColumn(name = "resources_id_resources")
	private Resources resources;
	
	@Column(name = "teacher_username")
	private String teacher_username;
	
	@Column(name = "teacher_password")
	private String teacher_password;

	public TeacherHasResources() {}
	
	
	

	public TeacherHasResources(int id_teacher_has_resource, Teacher teacher, Resources resources,
			String teacher_username, String teacher_password) {
		super();
		this.id_teacher_has_resource = id_teacher_has_resource;
		this.teacher = teacher;
		this.resources = resources;
		this.teacher_username = teacher_username;
		this.teacher_password = teacher_password;
	}




	public int getId_teacher_has_resource() {
		return id_teacher_has_resource;
	}

	public void setId_teacher_has_resource(int id_teacher_has_resource) {
		this.id_teacher_has_resource = id_teacher_has_resource;
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
	};
	
	

	

}
