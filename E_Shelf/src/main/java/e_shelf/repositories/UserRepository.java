package e_shelf.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import e_shelf.domains.database.Users;

public interface UserRepository extends CrudRepository<Users, Integer> {

    @Query("SELECT u FROM Users u WHERE u.username = :username")
    public Users getUserByUsername(@Param("username") String username);
}
