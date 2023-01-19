package bootcamp.it.exercise.forum.controllers;


import bootcamp.it.exercise.forum.session.SessionObject;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {
    @Resource
    SessionObject sessionObject;



    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        String welcome = "Witamy na stronie głównej";
        String succesfullyLogged = "Zarejestrowano pomyślnie";
        model.addAttribute("welcome", welcome);
        model.addAttribute("sessionObject",sessionObject);
        if (sessionObject.getUser() != null) {
            model.addAttribute("successfullyLogged", succesfullyLogged);
        }
        return "main";
    }




    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        String informations = "Ten projekt powstał w celach dydaktycznych przez Michała Kruczałę :)";
        model.addAttribute("info", informations);
        model.addAttribute("sessionObject",sessionObject);
        return "contact";
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String news(Model model) {
        String posts = "Jakieś posty";
        model.addAttribute("posts", posts);
        model.addAttribute("sessionObject",this.sessionObject);
        return "posts";
        ////zrobić szablon news:)

    }


}
