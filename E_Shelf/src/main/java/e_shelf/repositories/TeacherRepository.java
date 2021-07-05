package e_shelf.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import e_shelf.domains.database.Teacher;

public interface TeacherRepository extends JpaRepository <Teacher, Integer> {
	
	
	List<Teacher>findByEmail(String email);
	
	List<Teacher>findById(int id_teacher);
	
	@Query(value = "SELECT * FROM teacher t WHERE t.first_name LIKE %:keyword% OR t.last_name like %:keyword% ", nativeQuery= true)
	List<Teacher>findByKeyword(@Param("keyword") String keyword);
	

}
