package project.Controller.API;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import project.Model.Post;
import project.Repository.LikeOrDislikeRepositoryCrud;
import project.Repository.PostRepositoryCrud;

import javax.persistence.Table;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@Table(name = "posts") // set table name, we're going to use.
public class PostControllerAPI
{

    //using AOP
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    //dependency injection...
    @Autowired
    private PostRepositoryCrud postRepositoryCrud;

    /**
     *
     * API for creating new posts.
     *
     * @param session
     * @param image_id
     * @return
     */
    @GetMapping(path="/api/user/post/test")
    public @ResponseBody String createPost(HttpSession session, @RequestParam("image_id") int image_id)
    {

        //model obj.
        Post postObj = new Post();

        //set all variabels for db-table
        postObj.setImage_path("test");

        postObj.setUserid((Integer)session.getAttribute("user_id"));

        postObj.setQuestion("Synes I jeg skal købe den her bil i blå farve?");

        //store
        postRepositoryCrud.save(postObj);

        return "OK";

    }

    /**
     *
     * API for getting posts the user havent liked or disliked.
     *
     */
    @GetMapping(path="/api/user/post")
    public @ResponseBody Iterable<Post> getPosts()
    {

        log.info("Getting all posts...");

        return postRepositoryCrud.findAll();

    }

    /**
     *
     * Gets posts where the user id equals to parameter.
     *
     * @param user_id
     * @return
     */
    @GetMapping(path="/api/user/post/{user_id}")
    public @ResponseBody
    Iterable<Post> getPostsWhereUserID(@PathVariable("user_id") int user_id)
    {

        log.info("Getting all posts where the user id is " + user_id);

        return postRepositoryCrud.findByUserid(user_id);

    }


}
