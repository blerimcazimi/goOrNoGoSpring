package project.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.Model.LikeOrDislike;
import project.Model.Post;

/**
 *
 * CrudRepository
 *
 *
 * Create, read, delete, update
 *
 *
 */

@Repository
public interface PostRepositoryCrud extends CrudRepository<Post, Long>
{

    public Iterable<Post> findByUserid(int userid);

}