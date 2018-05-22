package project.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.Model.LikeOrDislike;
import project.Model.Post;

@Repository
public interface PostRepositoryCrud extends CrudRepository<Post, Long>
{

}