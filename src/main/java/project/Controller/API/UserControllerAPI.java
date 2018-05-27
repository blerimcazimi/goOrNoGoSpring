package project.Controller.API;

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

    @Autowired
    private UserRepositoryCrud userRepositoryCrud;


    @Autowired
    private PostRepositoryCrud postRepositoryCrud;

    /**
     *
     * Returns all users when calling the api.
     * @return
     *
     */
    @GetMapping(path="/api/user/all")
    public @ResponseBody
    Iterable<User> getAllUsers()
    {

        return userRepositoryCrud.findAll();

    }

    /**
     *
     * Get a single user.
     *
     * @return
     */
    @GetMapping(value = "/api/user")
    public @ResponseBody HashMap<String, String> findUserByID()
    {

        //put data into hashmap..
        HashMap<String, String> userData = new HashMap<String, String>();

        userData.put("id", Integer.toString(10));

        //return data...
        return userData;

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

        //establish connection with fb graph..
        FacebookGraph facebookGraph = new FacebookGraph();
        String facebook_id = facebookGraph.getFacebookIDByAccessToken(token);

        //user id
        int user_id;

        //user does not exist. Create it.
        if(!userRepositoryCrud.existsByFacebook(facebook_id))
        {

            //set data and save..
            User user = new User();
            user.setFacebook(facebook_id);

            //save data..
            userRepositoryCrud.save(user);

            //registration done, set user id...
            user_id = user.getID();

            //fb id exists, get user_id
        } else {

            user_id = userRepositoryCrud.findByFacebook(facebook_id).getID();

        }

        //set session by user id (logged in now)...
        session.setAttribute("user_id", user_id);

        //everything went fine, return OK.
        return "OK";

    }

}
