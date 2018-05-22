package project.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserHomeController
{

    @GetMapping("/user/home")
    public String index(Model model, HttpSession session)
    {

        //not logged in, return home..
        if(session.getAttribute("user_id") == null)
        {

            return "redirect:/";

        }

        //do logic for home here...

        return "user/home";

    }

}
