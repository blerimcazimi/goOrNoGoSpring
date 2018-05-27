package project.Controller.API;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import project.Model.LikeOrDislike;
import project.Repository.LikeOrDislikeRepositoryCrud;

import javax.servlet.http.HttpSession;

@Controller
public class LikeControllerAPI
{

    @Autowired
    private LikeOrDislikeRepositoryCrud likeOrDislikeRepositoryCrud;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @PostMapping(path="/api/user/image/likeOrDislike")
    public @ResponseBody String likeOrDislikeImage(HttpSession session, @RequestParam("image_id") int image_id,
                                                   @RequestParam("likeOrDislike") int likeOrDislike)
    {

        log.info("Trying to like post " + image_id);

        //login is required..
        if(session.getAttribute("user_id") == null)
        {

            log.info("Like failed, not logged in.");

            return "error";

        }

        LikeOrDislike likeOrDislikeObj = new LikeOrDislike();

        likeOrDislikeObj.setPost_id(image_id);

        likeOrDislikeObj.setLike_or_dislike(likeOrDislike);

        likeOrDislikeObj.setUserid((Integer)session.getAttribute("user_id"));

        likeOrDislikeRepositoryCrud.save(likeOrDislikeObj);

        log.info("Like done.");

        return "OK";

    }



}
