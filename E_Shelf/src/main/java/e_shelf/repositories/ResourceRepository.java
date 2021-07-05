package e_shelf.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import e_shelf.domains.database.Resources;
import e_shelf.domains.database.Teacher;

public interface ResourceRepository extends JpaRepository <Resources, Integer>{

	@Query("SELECT r FROM Resources r ORDER BY resource_name")
	List<Resources> findByResourceName();
	
	List<Resources> findById(int id_resources);
	
	@Query(value = "SELECT * FROM resources r WHERE r.resouce_name LIKE %:keyword% ", nativeQuery= true)
	List<Resources>findByKeyword(@Param("keyword") String keyword);
}
