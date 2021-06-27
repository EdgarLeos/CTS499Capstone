package e_shelf.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import e_shelf.domains.database.Teacher;

public interface TeacherRepository extends JpaRepository <Teacher, Integer> {
	
	
	List<Teacher>findByEmail(String email);
	
	List<Teacher>findById(int id_teacher);
	

}
