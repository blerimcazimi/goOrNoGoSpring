package project.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.Model.LikeOrDislike;

import javax.persistence.Table;

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
public interface LikeOrDislikeRepositoryCrud extends CrudRepository<LikeOrDislike, Long>
{

}