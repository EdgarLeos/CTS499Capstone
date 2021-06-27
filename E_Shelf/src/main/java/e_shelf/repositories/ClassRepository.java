package e_shelf.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import e_shelf.domains.database.Class;

public interface ClassRepository extends JpaRepository <Class, Integer>{

	@Query("SELECT c FROM Class c ORDER BY class_name")
	List<Class> findByClassName();
}
