package e_shelf.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import e_shelf.domains.database.Class;
import e_shelf.domains.database.Resources;

public interface ClassRepository extends JpaRepository <Class, Integer>{

	@Query("SELECT c FROM Class c ORDER BY class_name")
	List<Class> findAllByClassName();
	
	@Query("SELECT c FROM Class c WHERE c.class_name = :class_name")
	Class findByClass_name(String class_name);
	
	List<Class> findById(int id_class);
	
	@Query(value = "SELECT * FROM class c JOIN school s ON c.school_id_school = s.id_school WHERE c.class_name LIKE %:keyword% OR s.school_name LIKE %:keyword%; ", nativeQuery= true)
	List<Class>findByKeyword(@Param("keyword") String keyword);
}
