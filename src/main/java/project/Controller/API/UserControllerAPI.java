package project.Controller.API;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.Controller.API.Facebook.FacebookGraph;
import project.Model.Post;
import project.Model.User;
import project.Repository.PostRepositoryCrud;
import project.Repository.UserRepositoryCrud;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class UserControllerAPI
{


    private final Logger log = LoggerFactory.getLogger(this.getClass());



    @Autowired
    private UserRepositoryCrud userRepositoryCrud;

    /**
     *
     * Returns all users when calling the api.
     * @return
     *
     */
    @GetMapping(path="/api/user/all")
    public @ResponseBody Iterable<User> getAllUsers()
    {

        return userRepositoryCrud.findAll();

    }

    /**
     *
     * Logins the user with FB - if the user does not exists it will be created.
     *
     * @param token
     * @param session
     * @return
     *
     */
    @PostMapping(value = "/api/user/login")
    public @ResponseBody String login(@RequestParam("token") String token, HttpSession session)
    {

        log.info("Trying to login to the website with facebook login...");

        //establish connection with fb graph..
        FacebookGraph facebookGraph = new FacebookGraph();
        String facebook_id = facebookGraph.getFacebookIDByAccessToken(token);

        //user id
        int user_id;

        //user does not exist. Create it.
        if(!userRepositoryCrud.existsByFacebook(facebook_id))
        {

            log.info("Creating user to the db as the fb id " + facebook_id + " is not registered to the db...");

            //set data and save..
            User user = new User();
            user.setFacebook(facebook_id);

            //save data..
            userRepositoryCrud.save(user);

            //registration done, set user id...
            user_id = user.getID();

            //fb id exists, get user_id
        } else {

            log.info(facebook_id + " exists in the db.. doing logging in..");


            user_id = userRepositoryCrud.findByFacebook(facebook_id).getID();

        }

        log.info("Setting user session...");

        //set session by user id (logged in now)...
        session.setAttribute("user_id", user_id);

        log.info("Session set, all is good. User is logged in.");

        //everything went fine, return OK.
        return "OK";

    }

}
