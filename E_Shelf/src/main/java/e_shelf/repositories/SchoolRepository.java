package e_shelf.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import e_shelf.domains.database.School;
public interface SchoolRepository extends JpaRepository <School, Integer>{

	@Query("SELECT s FROM School s ORDER BY school_name")
	List<School> findByScholName();
}
