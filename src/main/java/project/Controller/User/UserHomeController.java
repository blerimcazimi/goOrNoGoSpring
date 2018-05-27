package project.Controller.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserHomeController
{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/user/home")
    public String index(HttpSession session)
    {

        //not logged in, return home..
        if(session.getAttribute("user_id") == null)
        {

            log.info("User tries to view /user/home but is not logged in...");

            return "redirect:/";

        }

        log.info("User (" + session.getAttribute("user_id") + ") is now viewing /user/home...");

        //do logic for home here...
        return "user/home";

    }

    @GetMapping("/user/logout")
    public String logOut(HttpSession session)
    {

        session.removeAttribute("user_id");

        return "redirect:/";

    }

}
