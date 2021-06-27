package e_shelf.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import e_shelf.domains.database.Resources;

public interface ResourceRepository extends JpaRepository <Resources, Integer>{

	@Query("SELECT r FROM Resources r ORDER BY resource_name")
	List<Resources> findByResourceName();
}
