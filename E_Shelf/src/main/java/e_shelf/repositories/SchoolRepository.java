package e_shelf.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import e_shelf.domains.database.Resources;
import e_shelf.domains.database.School;
public interface SchoolRepository extends JpaRepository <School, Integer>{

	@Query("SELECT s FROM School s ORDER BY school_name")
	List<School> findByScholName();
	
	@Query(value = "SELECT * FROM school s WHERE s.school_name LIKE %:keyword% ", nativeQuery= true)
	List<School>findByKeyword(@Param("keyword") String keyword);
}

