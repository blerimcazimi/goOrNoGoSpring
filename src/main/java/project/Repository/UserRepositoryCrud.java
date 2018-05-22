package project.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.Model.User;

import javax.persistence.Table;

@Repository
@Table(name = "users") // set table name, we're going to use.
public interface UserRepositoryCrud extends CrudRepository<User, Long>
{

    public User findByFacebook(String facebook);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM User c WHERE c.facebook = :facebookID")
    boolean existsByFacebook(@Param("facebookID") String facebookID);

}