package project.Controller.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import project.Model.Post;
import project.Repository.LikeOrDislikeRepositoryCrud;
import project.Repository.PostRepositoryCrud;

import javax.persistence.Table;
import javax.servlet.http.HttpSession;

@Controller
@Table(name = "posts") // set table name, we're going to use.
public class PostControllerAPI
{

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

        Post postObj = new Post();

        postObj.setImage_path("test");

        postObj.setUserid((Integer)session.getAttribute("user_id"));

        postObj.setQuestion("Synes I jeg skal købe den her bil i blå farve?");

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

        return postRepositoryCrud.findAll();

    }


}
