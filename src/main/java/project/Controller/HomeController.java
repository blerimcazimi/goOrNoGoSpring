package project.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import project.Controller.API.Facebook.FacebookGraph;
import project.Model.User;
import project.Repository.UserRepositoryCrud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController
{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String index(HttpSession session)
    {

        log.info("Visiting home page..");

        //logged in return to user home..
        if(session.getAttribute("user_id") != null)
        {

            log.info("User is logged in, redirecting to user-home");

            return "redirect:/user/home";

        }

        log.info("User is not logged in. Displaying /");

        return "index";

    }


}
